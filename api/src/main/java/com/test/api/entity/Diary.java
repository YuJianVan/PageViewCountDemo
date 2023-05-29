package com.test.api.entity;

import lombok.Data;

@Data
public class Diary {
    /**
     * id
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 图片地址
     */
    private String pic;

    /**
     * 内容
     */
    private String content;

    /**
     * 城市
     */
    private String city;
}
