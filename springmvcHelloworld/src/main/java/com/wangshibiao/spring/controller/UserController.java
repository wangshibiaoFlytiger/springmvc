package com.wangshibiao.spring.controller;

import com.google.gson.Gson;
import com.wangshibiao.spring.model.User;
import com.wangshibiao.spring.service.UserService;
import org.apache.shiro.crypto.hash.Hash;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Wang Shibiao on 2016/6/3.
 */
@Controller
public class UserController {
    @Resource
    UserService userService;

    @RequestMapping(value = "/user/getUser.json", method = RequestMethod.GET)
    public void getUser(HttpServletRequest request, HttpServletResponse response,
                        String username){
        User user = userService.getUserByUserName(username);
        try {
            response.getWriter().write(new Gson().toJson(user));
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
