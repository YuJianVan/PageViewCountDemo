package com.test.api.vo;

import lombok.Data;

import java.util.List;

@Data
public class CityVo {
    /**
     * id
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 城市
     */
    private List<String> city;

    /**
     * 类型，区分点亮和想去
     */
    private Integer type;
}
