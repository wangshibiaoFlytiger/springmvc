package com.wangshibiao.springbootdemo.controller;

import com.wangshibiao.springbootdemo.dao.UserDao;
import com.wangshibiao.springbootdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public ResponseEntity deleteUser(HttpServletRequest request, HttpServletResponse response,
                                        @PathVariable String id){
        userDao.delete(id);
        return ResponseEntity.ok().body(null);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserById(HttpServletRequest request, HttpServletResponse response,
                                 @PathVariable String id){
        User user = userDao.getById(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAllUsers(HttpServletRequest request, HttpServletResponse response){
        List<User> userList = userDao.findAll();
        return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
    }

    /**
     * 分页查询
     * @param request
     * @param response
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/userPages", method = RequestMethod.GET)
    public ResponseEntity<Page<User>> findUserPage(HttpServletRequest request, HttpServletResponse response,
                                                   Integer page,
                                                   Integer size){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        Page<User> userPage = userDao.findAll(pageable);
        return new ResponseEntity<Page<User>>(userPage, HttpStatus.OK);
    }
}
