package com.fyj.pageviewcountdemo.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitMqConfig {
    /************************************以下为延迟队列+死信队列************************************/
    /**
     * 声明延时Exchange
     * @return
     */
    @Bean("delayExchange")
    public DirectExchange delayExchange(){
        return new DirectExchange(MqQueueConstant.DELAY_EXCHANGE_NAME);
    }

    /**
     * 声明死信Exchange
     * @return
     */
    @Bean("deadLetterExchange")
    public DirectExchange deadLetterExchange(){
        return new DirectExchange(MqQueueConstant.DEAD_LETTER_EXCHANGE);
    }


    /**
     * 声明延时队列 不设置TTL
     * 并绑定到对应的死信交换机
     * @return
     */
    @Bean("delayQueue")
    public Queue delayQueue(){
        Map<String, Object> args = new HashMap<>(3);
        // x-dead-letter-exchange    这里声明当前队列绑定的死信交换机
        args.put("x-dead-letter-exchange", MqQueueConstant.DEAD_LETTER_EXCHANGE);
        // x-dead-letter-routing-key  这里声明当前队列的死信路由key
        args.put("x-dead-letter-routing-key", MqQueueConstant.DEAD_LETTER_QUEUE_ROUTING_KEY);
        return QueueBuilder.durable(MqQueueConstant.DELAY_QUEUE_NAME).withArguments(args).build();
    }

    /**
     * 声明死信队列 用于接收延时任意时长处理的消息
     * @return
     */
    @Bean("deadLetterQueue")
    public Queue deadLetterQueue(){
        return new Queue(MqQueueConstant.DEAD_LETTER_QUEUE_NAME);
    }

    /**
     * 声明延时队列绑定关系
     * @param queue
     * @param exchange
     * @return
     */
    @Bean
    public Binding delayBinding(@Qualifier("delayQueue") Queue queue, @Qualifier("delayExchange") DirectExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(MqQueueConstant.DELAY_QUEUE_ROUTING_KEY);
    }

    /**
     * 声明死信队列绑定关系
     * @param queue
     * @param exchange
     * @return
     */
    @Bean
    public Binding deadLetterBinding(@Qualifier("deadLetterQueue") Queue queue, @Qualifier("deadLetterExchange") DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(MqQueueConstant.DEAD_LETTER_QUEUE_ROUTING_KEY);
    }
}
