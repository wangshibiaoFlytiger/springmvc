package com.wangshibiao.springbootdemo.controller;

import com.wangshibiao.springbootdemo.dao.UserDao;
import com.wangshibiao.springbootdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Wang Shibiao on 2017/2/8.
 */
@RestController
public class UserController {
    @Autowired
    private UserDao userDao;

    @RequestMapping("/")
    String home(){
        return "Hello World!";
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User findUserById(HttpServletRequest request, HttpServletResponse response,
                                 @PathVariable String id){
        User user = userDao.findById(id);
        return user;
    }
}
