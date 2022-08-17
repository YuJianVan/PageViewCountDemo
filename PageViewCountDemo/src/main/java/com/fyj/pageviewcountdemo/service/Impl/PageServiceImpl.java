package com.fyj.pageviewcountdemo.service.Impl;

import com.fyj.pageviewcountdemo.config.MqQueueConstant;
import com.fyj.pageviewcountdemo.mapper.PageMapper;
import com.fyj.pageviewcountdemo.service.PageService;
import com.fyj.pageviewcountdemo.service.ViewCountService;
import com.fyj.pageviewcountdemo.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PageServiceImpl implements PageService {
    @Autowired
    private PageMapper pageMapper;

    @Autowired(required = false)
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Integer getViewCount(String id) {
        /*viewCountIncrement(id);
        return pageMapper.getViewCountById(id);*/
        return (Integer)redisTemplate.opsForHash().get("view_count",id);
    }

    @Override
    public Result<String> addPageView(String id) {
        viewCountIncrement(id);
        return Result.success(200,"成功！");
    }

    public void viewCountIncrement(String id){
        redisTemplate.opsForHash().increment("view_count",id,1);
        rabbitTemplate.convertAndSend(MqQueueConstant.DELAY_EXCHANGE_NAME, MqQueueConstant.DELAY_QUEUE_ROUTING_KEY, id, a ->{
            log.info("生产者发送了1条消息");
            a.getMessageProperties().setExpiration(String.valueOf(10000));
            return a;
        });
    }
}