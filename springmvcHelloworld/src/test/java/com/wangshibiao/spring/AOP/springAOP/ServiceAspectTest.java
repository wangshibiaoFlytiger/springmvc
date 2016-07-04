package com.wangshibiao.spring.AOP.springAOP;

import com.wangshibiao.spring.BaseTest;
import com.wangshibiao.spring.model.User;
import com.wangshibiao.spring.service.UserService;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by Wang Shibiao on 2016/7/4.
 */
public class ServiceAspectTest extends BaseTest{
    @Resource
    UserService userService;

    @Test
    public void springAOPTest(){
        User user = userService.getUserByUserName("admin");
        userService.addUser();
    }
}
