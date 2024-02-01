package com.cjj.forum.common;

import lombok.Getter;

@Getter
public enum ReturnCode {
    SUCCESS(0, "OK"),
    PARAMETER_MISS(1001, "缺少参数"),

    // 用户登录
    USER_MISS(2000, "用户不存在"),
    USER_ERROR_PASS(2001, "用户密码错误"),
    USER_BANNED(2002, "用户被禁言"),

    // 用户注册
    USER_ERROR_CHECK_PASS(2001, "用户确认密码不一致"),
    USER_EXISTS(2003, "用户已存在"),

    // 服务器内部问题
    SERVICE_ERROR(5000, "服务器出现问题，请联系管理员"),
    ;



    ReturnCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    final int code;
    final String message;
}
