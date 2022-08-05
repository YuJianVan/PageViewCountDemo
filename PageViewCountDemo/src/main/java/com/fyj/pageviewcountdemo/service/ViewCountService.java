package com.fyj.pageviewcountdemo.service;

import com.fyj.pageviewcountdemo.entity.Page;
import com.fyj.pageviewcountdemo.mapper.PageMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class ViewCountService {
    @Autowired
    private PageMapper pageMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @PostConstruct
    public void initViewCount(){
        List<Page>list=pageMapper.getPageInfoList();
        for(Page page:list){
            redisTemplate.opsForHash().put("view_count", String.valueOf(page.getId()),page.getPageView());
        }
    }
}
