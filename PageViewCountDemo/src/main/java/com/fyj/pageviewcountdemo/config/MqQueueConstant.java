package com.fyj.pageviewcountdemo.config;

public interface MqQueueConstant {
    /**
     * 延迟队列交换机
     */
    String DELAY_EXCHANGE_NAME = "delay.queue.business.exchange";

    /**
     * 延迟队列路由key
     */
    String DELAY_QUEUE_ROUTING_KEY = "delay.queue.business.queue.routingkey";

    /**
     * 延迟队列名称
     */
    String DELAY_QUEUE_NAME = "delay.queue.business.queue";

    /**
     * 死信队列死信交换机
     */
    String DEAD_LETTER_EXCHANGE = "delay.queue.deadletter.exchange";

    /**
     * 死信队列死信路由key
     */
    String DEAD_LETTER_QUEUE_ROUTING_KEY = "delay.queue.deadletter.routingkey";

    /**
     * 死信队列名称
     */
    String DEAD_LETTER_QUEUE_NAME = "delay.queue.deadletter.queue";
}
