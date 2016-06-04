package com.wangshibiao.spring.service;

import com.wangshibiao.spring.model.User;
import org.springframework.stereotype.Service;

/**
 * Created by Wang Shibiao on 2016/6/5.
 */
@Service
public class UserService {
    public User findByUsername(String username){
        User user = new User();
        user.setUsername("wangshibiao");
        user.setName("王世彪");
        return user;
    }
}
