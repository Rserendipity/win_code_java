package com.cjj.forum.controller;

import com.cjj.forum.common.ResultBody;
import com.cjj.forum.common.ReturnCode;
import com.cjj.forum.modle.dto.UserLoginDto;
import com.cjj.forum.modle.dto.UserLogoutDto;
import com.cjj.forum.modle.dto.UserRegisterDto;
import com.cjj.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResultBody login(@RequestBody UserLoginDto user) {
        if (user == null) {
            return ResultBody.fail(ReturnCode.PARAMETER_MISS);
        }
        return userService.login(user);
    }

    @PostMapping("/register")
    public ResultBody register(@RequestBody UserRegisterDto user) {
        if (user == null) {
            return ResultBody.fail(ReturnCode.PARAMETER_MISS);
        }
        return userService.register(user);
    }

    @PostMapping("/logout")
    public ResultBody logout(@RequestBody UserLogoutDto user) {
        if (user == null) {
            return ResultBody.fail(ReturnCode.PARAMETER_MISS);
        }

        return userService.logout(user);
    }

}
