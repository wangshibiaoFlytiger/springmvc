package com.wangshibiao.spring.service;

import com.wangshibiao.spring.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Wang Shibiao on 2016/6/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/mainCtx.xml")
@Transactional
public class UserServiceTest {
    @Resource
    UserService userService;

    @Test
    public void getUserByUserName(){
        User user = userService.getUserByUserName("admin");
    }
}
