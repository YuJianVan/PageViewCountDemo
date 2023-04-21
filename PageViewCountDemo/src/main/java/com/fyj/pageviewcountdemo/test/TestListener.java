package com.fyj.pageviewcountdemo.test;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class TestListener {
    @EventListener
    public void listener(String str){
        System.out.println("接收到1条消息："+str);
    }
}
