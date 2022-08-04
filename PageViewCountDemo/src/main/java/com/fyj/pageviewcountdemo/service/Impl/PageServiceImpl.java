package com.fyj.pageviewcountdemo.service.Impl;

import com.fyj.pageviewcountdemo.mapper.PageMapper;
import com.fyj.pageviewcountdemo.service.PageService;
import com.fyj.pageviewcountdemo.service.ViewCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PageServiceImpl implements PageService {
    @Autowired(required = false)
    private PageMapper pageMapper;

    @Autowired
    private ViewCountService viewCountService;

    @Override
    public int getViewCount(String id) {
        viewCountService.ViewCountIncrement(id);
        return pageMapper.getViewCountById(id);
    }

}