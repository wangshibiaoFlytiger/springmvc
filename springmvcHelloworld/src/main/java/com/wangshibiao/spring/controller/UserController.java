package com.wangshibiao.spring.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wangshibiao.spring.model.User;
import com.wangshibiao.spring.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Wang Shibiao on 2016/6/3.
 */
@Controller
public class UserController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    UserService userService;

    @RequestMapping(value = "/user/getUser.json", method = RequestMethod.GET)
    public void getUser(HttpServletRequest request, HttpServletResponse response,
                        String username){
        logger.debug("Enter /user/getUser.json");
        User user = userService.getUserByUserName(username);

        response.setCharacterEncoding("UTF-8");
        try {
            response.getWriter().write(new Gson().toJson(user, new TypeToken<User>(){}.getType()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ResponseBody
    @RequestMapping(value = "/user/userList.json", method = RequestMethod.GET)
    public String getUserList(HttpServletRequest request, HttpServletResponse response,
                              Integer pageNum,
                              Integer pageSize){
        List<User> userList = userService.findByPage(pageNum, pageSize);

        //置空User对象的懒加载属性，否则json转换失败
        for (Iterator<User> iterator = userList.iterator(); iterator.hasNext();){
            User user = iterator.next();
            user.setOrg(null);
        }

        String userListJson = JSON.toJSONString(userList);
        return userListJson;
    }

    @Transactional
    @RequestMapping(value = "/user/addUser.json")
    public void addUser(HttpServletRequest request, HttpServletResponse response){
        User user1 = new User();
        user1.setName("name062602");
        user1.setPassword("pass11");
        userService.addUserModel(user1);

        User user2 = new User();
        user2.setName("name062603");
        user2.setPassword("pass11");
        userService.addUserModel(user2);

        userService.addUser();

        response.setCharacterEncoding("UTF-8");
        try {
            response.getWriter().write(new Gson().toJson(null));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/user/testpage.html", method = RequestMethod.GET)
    public ModelAndView page1(){
        Map map = new HashMap<>();
        map.put("para1", "您好1");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("data", map);
        modelAndView.addObject("test", "good");
        return modelAndView;
    }
}
