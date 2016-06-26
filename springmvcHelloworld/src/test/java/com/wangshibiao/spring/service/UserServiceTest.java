package com.wangshibiao.spring.service;

import com.wangshibiao.spring.BaseTest;
import com.wangshibiao.spring.dao.UserMapper;
import com.wangshibiao.spring.model.User;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by Wang Shibiao on 2016/6/24.
 */
public class UserServiceTest extends BaseTest{
    @Resource
    UserService userService;
    @Resource
    UserMapper userMapper;

    @Test
    public void getUserByUserName(){
        User user = userService.getUserByUserName("admin");
    }

    //测试类的事务：测试方法执行完成后，不会影响数据库记录，因事务控制使之回滚
    @Test
    public void transaction(){
        User user = new User();
        user.setName("name0626");
        user.setPassword("pass1");
        userMapper.insert(user);
    }
}
