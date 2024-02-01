package com.cjj.forum;

import com.cjj.forum.mapper.UserMapper;
import com.cjj.forum.modle.entity.User;
import com.cjj.forum.utils.UserPasswordUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

class ForumApplicationTests {

    @Test
    public void testSelect() {
    }

    @Test
    public void testUtil() {
        String salt = UserPasswordUtil.getSalt();
        String password = UserPasswordUtil.getPassword("123", "4e15f51a-e93a-4318-84e0-f0d8b5d13796");
        System.out.println(salt);
        // raw:         123
        // salt:        4e15f51a-e93a-4318-84e0-f0d8b5d13796
        // password:    a643f7e2941ccf47aba9ba4ce2ceda69
        System.out.println(password);
    }

//    @Resource
//    private DataSource dataSource;
//
//    @Test
//    void testDB() {
//        System.out.println(dataSource);
//    }

}
