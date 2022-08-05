package com.fyj.pageviewcountdemo.config;

import com.fyj.pageviewcountdemo.entity.Page;
import com.fyj.pageviewcountdemo.mapper.PageMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class RabbitMQListener {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private PageMapper pageMapper;

    @RabbitListener(queues = "pv-topic-queue")
    public void process(String msg) {
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
