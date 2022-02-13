package com.passbook.passbook.service;

import com.alibaba.fastjson.JSON;
import com.passbook.passbook.vo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 用户服务测试
 */
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private IUserService userService;

    @Test
    public void testCreateUser() throws Exception {

        User user = new User();
        user.setBaseInfo(new User.BaseInfo("test", 10, "m"));
        user.setOtherInfo(new User.OtherInfo("123456", "Beijing"));

        System.out.println(JSON.toJSONString(userService.createUser(user)));
    }
}
