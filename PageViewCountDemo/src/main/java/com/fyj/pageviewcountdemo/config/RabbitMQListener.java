package com.fyj.pageviewcountdemo.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQListener {
    @RabbitListener(queues = "pv-topic-queue")
    public void process(String msg) {
        System.out.println("消息队列1接收到的消息为：" + msg);
    }
}
