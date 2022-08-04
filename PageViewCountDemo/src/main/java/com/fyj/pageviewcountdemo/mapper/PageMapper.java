package com.fyj.pageviewcountdemo.mapper;

import org.apache.ibatis.annotations.Param;

public interface PageMapper {
    Integer getViewCountById(@Param("id") String id);
}
