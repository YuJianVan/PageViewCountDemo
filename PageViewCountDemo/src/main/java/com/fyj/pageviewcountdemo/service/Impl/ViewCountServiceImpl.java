package com.fyj.pageviewcountdemo.service.Impl;

import com.fyj.pageviewcountdemo.service.ViewCountService;
import org.springframework.stereotype.Service;

@Service
public class ViewCountServiceImpl implements ViewCountService {
    @Override
    public int getViewCount(String id) {
        return 1;
    }
}
