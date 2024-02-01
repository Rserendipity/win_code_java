package com.cjj.forum.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cjj.forum.common.ResultBody;
import com.cjj.forum.common.ReturnCode;
import com.cjj.forum.mapper.UserMapper;
import com.cjj.forum.modle.dto.UserLoginDto;
import com.cjj.forum.modle.dto.UserLogoutDto;
import com.cjj.forum.modle.dto.UserRegisterDto;
import com.cjj.forum.modle.entity.User;
import com.cjj.forum.modle.vo.UserVo;
import com.cjj.forum.service.UserService;
import com.cjj.forum.utils.UserPasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    public ResultBody login(UserLoginDto dto) {
        // 确认dto非空
        if (!StringUtils.hasLength(dto.getAccount()) || !StringUtils.hasLength(dto.getPassword())) {
            return ResultBody.fail(ReturnCode.PARAMETER_MISS);
        }

        // 查询用户
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("account", dto.getAccount()));

        // 用户不存在
        if (user == null || !StringUtils.hasLength(user.getAccount()) || user.getDeletestate() == 1) {
            return ResultBody.fail(ReturnCode.USER_MISS);
        }

        // 确认密码
        if (!UserPasswordUtil.getPassword(dto.getPassword(), user.getSalt()).equals(user.getPassword())) {
            return ResultBody.fail(ReturnCode.USER_ERROR_PASS);
        }

        // 用户被禁言
        if (user.getState() == 1) {
            return ResultBody.fail(ReturnCode.USER_BANNED);
        }

        // 返回脱敏后的用户信息
        return ResultBody.success(new UserVo(user));
    }

    public ResultBody logout(UserLogoutDto user) {
        return ResultBody.success();
    }

    public ResultBody register(UserRegisterDto dto) {
        // 确认dto非空
        if (!StringUtils.hasLength(dto.getAccount()) || !StringUtils.hasLength(dto.getPassword())|| !StringUtils.hasLength(dto.getConfirmPass())) {
            return ResultBody.fail(ReturnCode.PARAMETER_MISS);
        }

        // 两次输入的密码不一致
        if (!dto.getPassword().equals(dto.getConfirmPass())) {
            return ResultBody.fail(ReturnCode.USER_ERROR_CHECK_PASS);
        }

        // 用户已存在
        Long count = userMapper.selectCount(new QueryWrapper<User>().eq("account", dto.getAccount()));
        if (count != 0) {
            return ResultBody.fail(ReturnCode.USER_EXISTS);
        }

        // 用户不存在，创建
        User user = new User();
        user.setAccount(dto.getAccount());
        user.setSalt(UserPasswordUtil.getSalt());
        user.setPassword(UserPasswordUtil.getPassword(dto.getPassword(), user.getSalt()));
        user.setArticlecount(0);
        user.setRole("USER");
        user.setCreatetime(new Date());
        user.setUpdatetime(new Date());

        userMapper.insert(user);

        return ResultBody.success();
    }
}
