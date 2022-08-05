package com.fyj.pageviewcountdemo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfirmConfig {
    //topic发布订阅模式,声明交换机
    @Bean
    public TopicExchange getTopicExchange(){
        return new TopicExchange("pv-topic-exchange");
    }

    //声明队列
    @Bean
    public Queue getQueueOne(){
        return new Queue("pv-topic-queue");
    }

    //将队列1绑定到topic交换机上
    @Bean
    public Binding getBindingTopic(TopicExchange getTopicExchange, Queue getQueueOne){
        return BindingBuilder.bind(getQueueOne).to(getTopicExchange).with("pv.*");
    }
}