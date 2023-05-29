package com.test.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.api.entity.Diary;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DiaryMapper extends BaseMapper<Diary> {

}
