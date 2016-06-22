package com.wangshibiao.spring.service;

import com.wangshibiao.spring.dao.UserDao;
import com.wangshibiao.spring.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Wang Shibiao on 2016/6/5.
 */
@Service
public class UserService {
    @Resource
    UserDao userDao;

    public User getUserByUserName(String userName) {
        return userDao.getUserByUserName(userName);
    }
}
