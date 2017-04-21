package com.wangshibiao.springboot.mybatisdemo.service;

import com.wangshibiao.springboot.mybatisdemo.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * Created by Wang Shibiao on 2017/4/21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional  //启用事务
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    public void testGetById() throws Exception {
         User user = userService.getById("23");
    }
}