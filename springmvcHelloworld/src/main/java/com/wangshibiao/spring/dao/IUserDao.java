package com.wangshibiao.spring.dao;

import com.wangshibiao.spring.model.User;

/**
 * Created by Wang Shibiao on 2016/6/21.
 */
public interface IUserDao {
    public User getUserByUserName(String userName);
}