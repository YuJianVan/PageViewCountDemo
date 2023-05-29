package com.test.api.entity;

import lombok.Data;

@Data
public class City {
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
    private String city;

    /**
     * 类型，区分点亮和想去
     */
    private Integer type;

}
