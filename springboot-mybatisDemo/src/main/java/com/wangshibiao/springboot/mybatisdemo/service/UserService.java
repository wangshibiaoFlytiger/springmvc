package com.wangshibiao.springboot.mybatisdemo.service;

import com.wangshibiao.springboot.mybatisdemo.dao.UserDao;
import com.wangshibiao.springboot.mybatisdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Wang Shibiao on 2017/4/21.
 */
@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public User getById(String id){
        return userDao.getById(id);
    }

    public void addUser(User user){
        userDao.insert(user);
    }

}
