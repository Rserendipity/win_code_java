package com.cjj.forum.modle.dto;

import lombok.Data;

@Data
public class UserRegisterDto {
    String account;
    String password;
    String confirmPass;
}
