package com.fyj.startdemo.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 电影
 */
@Data
@TableName("`film`")
@NoArgsConstructor
@AllArgsConstructor
public class Film implements Serializable {

    private Integer id;

    private String name;

    //上映时间
    private String releaseTime;

    //类型
    private String type;

    //状态
    private boolean status;

    //地区 中国,美国,韩国 ......
    private String region;

    //电影简介
    private String introduction;

    //封面图片
    private String cover;

    //电影时长 单位：分钟
    private Integer duration;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "create_at",fill = FieldFill.INSERT)
    private LocalDateTime createAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "update_at",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateAt;

}
