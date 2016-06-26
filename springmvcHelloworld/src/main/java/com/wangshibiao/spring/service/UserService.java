package com.wangshibiao.spring.service;

import com.wangshibiao.spring.dao.UserMapper;
import com.wangshibiao.spring.model.User;
import com.wangshibiao.spring.model.UserExample;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Wang Shibiao on 2016/6/5.
 */
@Service
public class UserService {
    @Resource
    UserMapper userMapper;

    public User getUserByUserName(String userName) {
        UserExample userExample = new UserExample();
        userExample.or()
                .andUsernameEqualTo(userName);
        List<User> userList = userMapper.selectByExample(userExample);
        return userList.get(0);
    }

    @Transactional
    public void addUser(){
        User user = new User();
        user.setName("name062601");
        user.setPassword("pass1");
        userMapper.insert(user);

        //出现异常，则该语句之前的数据库操作会做回滚
        Integer a = 6/0;
    }

    @Transactional
    public void addUserModel(User user){
        userMapper.insert(user);
    }
}
