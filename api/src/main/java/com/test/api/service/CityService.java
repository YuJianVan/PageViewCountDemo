package com.test.api.service;

import com.test.api.vo.CityVo;

public interface CityService {
    CityVo queryCity(CityVo cityVo);

    void setCity(CityVo cityVo);
}
