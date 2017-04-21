package com.wangshibiao.springboot.mybatisdemo.controller;

import com.wangshibiao.springboot.mybatisdemo.dao.UserDao;
import com.wangshibiao.springboot.mybatisdemo.model.User;
import com.wangshibiao.springboot.mybatisdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Wang Shibiao on 2017/2/8.
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserById(HttpServletRequest request, HttpServletResponse response,
                                            @PathVariable String id){
        User user = userService.getById(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}
