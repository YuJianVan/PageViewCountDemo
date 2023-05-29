package com.test.api.vo;

import lombok.Data;

import java.util.List;

@Data
public class DiaryVo {
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
    private List<String> pic;

    /**
     * 内容
     */
    private String content;

    /**
     * 城市
     */
    private String city;
}
