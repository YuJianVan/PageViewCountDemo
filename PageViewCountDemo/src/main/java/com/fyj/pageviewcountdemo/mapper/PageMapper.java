package com.fyj.pageviewcountdemo.mapper;

import com.fyj.pageviewcountdemo.entity.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PageMapper {
    Integer getViewCountById(@Param("id") String id);

    List<Page> getPageInfoList();
}
