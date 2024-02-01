package com.cjj.forum.utils;


import org.springframework.util.DigestUtils;

import java.util.UUID;

public class UserPasswordUtil {

    // 获取随机盐值
    public static String getSalt() {
        return UUID.randomUUID().toString();
    }

    // 通过 原始密码 + 盐 生成真正的密码
    public static String getPassword(String rawPassword, String salt) {
        return DigestUtils.md5DigestAsHex(( "cjj" + rawPassword + salt).getBytes());
    }
}
