package com.fyj.pageviewcountdemo.vo;

import lombok.Getter;

/**
 * Desc: 统 一 返 回 状 态 码
 */
public enum ResultCode {
    /**操作成功**/
    RC200(200,"操作成功"),
    /**操作失败**/
    RC500(500,"操作失败");

    /**自定义状态码**/
    @Getter
    private final int code;

    /**
     * 携 带 消 息
     */
    @Getter
    private final String message;
    /**
     * 构 造 方 法
     */
    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}

