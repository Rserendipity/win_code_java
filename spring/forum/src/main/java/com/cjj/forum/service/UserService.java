package com.cjj.forum.service;

import com.cjj.forum.common.ResultBody;
import com.cjj.forum.modle.dto.UserLoginDto;
import com.cjj.forum.modle.dto.UserLogoutDto;
import com.cjj.forum.modle.dto.UserRegisterDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    ResultBody login(UserLoginDto user);
    ResultBody logout(UserLogoutDto user);
    ResultBody register(UserRegisterDto user);
}
