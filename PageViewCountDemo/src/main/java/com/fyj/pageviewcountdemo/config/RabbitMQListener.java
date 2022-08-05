package com.fyj.pageviewcountdemo.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class RabbitMQListener {
    @Autowired
    private RedisTemplate redisTemplate;

    @RabbitListener(queues = "pv-topic-queue")
    public void process(String msg) {
        Map<Object, Object> countMap = redisTemplate.opsForHash().entries("view_count");
        for (Map.Entry<Object,Object> entry : countMap.entrySet()){
            Integer id = Integer.parseInt(entry.getKey().toString());
            Integer count = Integer.parseInt(entry.getValue().toString());

        }
    }
}
