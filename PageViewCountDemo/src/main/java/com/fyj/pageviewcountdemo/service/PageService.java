package com.fyj.pageviewcountdemo.service;

import com.fyj.pageviewcountdemo.vo.Result;

public interface PageService {
    Integer getViewCount(String id);
    Result<String> addPageView(String id);
}
