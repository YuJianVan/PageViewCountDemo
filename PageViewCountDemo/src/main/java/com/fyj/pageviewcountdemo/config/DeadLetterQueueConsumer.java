package com.fyj.pageviewcountdemo.config;

import com.fyj.pageviewcountdemo.entity.Page;
import com.fyj.pageviewcountdemo.mapper.PageMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 死信队列消费者
 */
@Slf4j
@Component
public class DeadLetterQueueConsumer {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private PageMapper pageMapper;

    //private ConcurrentHashMap<Integer,Long>map=new ConcurrentHashMap<>();
    private Long lastUpdateTime=0L;

    private static final Integer UPDATE_THRESHOLD=10000;
    /**
     * 指定时间处理逻辑
     * @param message
     * @throws IOException
     */
    @RabbitListener(queues = MqQueueConstant.DEAD_LETTER_QUEUE_NAME)
    public void receive(Message message){
        String msg = new String(message.getBody());
        log.info("当前时间：{},死信队列收到消息：{}", new Date().toString(), msg);
        Long curTime=System.currentTimeMillis();
        if(curTime-lastUpdateTime>=UPDATE_THRESHOLD){
            updateViewCount();
            lastUpdateTime=System.currentTimeMillis();
            log.info("已全量更新浏览量");
        }
    }

    public void updateViewCount(){
        // 遍历redis中阅读量数据，写入数据库
        Map<Object, Object> countMap = redisTemplate.opsForHash().entries("view_count");
        List<Page> list=new ArrayList<>();
        for (Map.Entry<Object,Object> entry : countMap.entrySet()){
            Integer id = Integer.parseInt(entry.getKey().toString());
            Integer count = Integer.parseInt(entry.getValue().toString());
            Page page=new Page();
            page.setId(id);
            page.setPageView(count);
            list.add(page);
        }
        pageMapper.updatePageView(list);
    }
}