package com.wangshibiao.springbootdemo.controller;

import com.wangshibiao.springbootdemo.dao.UserDao;
import com.wangshibiao.springbootdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
    private UserDao userDao;

    @RequestMapping("/")
    String home(){
        return "Hello World!";
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<User> addUser(HttpServletRequest request, HttpServletResponse response,
                                        @RequestBody User user){
        user = userDao.save(user);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(HttpServletRequest request, HttpServletResponse response,
                                        @RequestBody User user){
        user = userDao.save(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public void deleteUser(HttpServletRequest request, HttpServletResponse response,
                                        @PathVariable String id){
        userDao.delete(id);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User findUserById(HttpServletRequest request, HttpServletResponse response,
                                 @PathVariable String id){
        User user = userDao.findById(id);
        return user;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> findAllUsers(HttpServletRequest request, HttpServletResponse response){
        List<User> userList = userDao.findAll();
        return userList;
    }
}
