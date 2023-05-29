package com.test.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.api.entity.City;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CityMapper extends BaseMapper<City> {

}
