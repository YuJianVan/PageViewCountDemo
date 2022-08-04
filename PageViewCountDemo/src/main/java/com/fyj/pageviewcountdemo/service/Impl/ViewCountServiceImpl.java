package com.fyj.pageviewcountdemo.service.Impl;

import com.fyj.pageviewcountdemo.mapper.PageMapper;
import com.fyj.pageviewcountdemo.service.ViewCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViewCountServiceImpl implements ViewCountService {
    @Autowired(required = false)
    private PageMapper pageMapper;

    @Override
    public int getViewCount(String id) {
        return pageMapper.getViewCountById(id);
    }
}
