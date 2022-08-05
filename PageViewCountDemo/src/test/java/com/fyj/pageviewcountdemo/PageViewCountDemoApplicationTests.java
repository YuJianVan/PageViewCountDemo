package com.fyj.pageviewcountdemo;

import com.fyj.pageviewcountdemo.entity.Page;
import com.fyj.pageviewcountdemo.mapper.PageMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootTest
class PageViewCountDemoApplicationTests {
    @Autowired
    private PageMapper pageMapper;

    @Test
    void contextLoads() {
        List<Page> list=new ArrayList<>();
        Page page1=new Page(1,10);
        Page page2=new Page(2,10);
        list.add(page1);
        list.add(page2);
        pageMapper.updatePageView(list);
    }

}
