package com.fyj.pageviewcountdemo;

import com.fyj.pageviewcountdemo.config.MqQueueConstant;
import com.fyj.pageviewcountdemo.entity.Page;
import com.fyj.pageviewcountdemo.mapper.PageMapper;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@SpringBootTest
class PageViewCountDemoApplicationTests {
    @Autowired
    private PageMapper pageMapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void contextLoads() {
        String msg="这是一条消息";
        rabbitTemplate.convertAndSend(MqQueueConstant.DELAY_EXCHANGE_NAME, MqQueueConstant.DELAY_QUEUE_ROUTING_KEY, msg, a ->{
            a.getMessageProperties().setExpiration(String.valueOf(1000));
            return a;
        });
    }

    @Test
    void test(){

    }
}
