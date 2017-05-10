package com.wangshibiao.springboot.mybatisdemo.controller;

import com.wangshibiao.springboot.mybatisdemo.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by Wang Shibiao on 2017/4/21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {
    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void testGetUserById() throws Exception {
        String url = "/users/{id}";

        Map paras = new HashMap<>();
        paras.put("id", "25");
        User user = testRestTemplate.getForObject(url, User.class, paras);
    }

    @Test
    public void testAddUser() throws Exception {
        User user = new User();
        user.setId("ff");
        user.setName("ff");
        user.setAge(46);

        String url = "/users";
        User userRet = testRestTemplate.postForObject(url, user, User.class);
    }
}