package com.wangshibiao.springbootdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Wang Shibiao on 2017/2/8.
 */
@RestController
public class AppController{
    @RequestMapping("/")
    String home(){
        return "Hello World!";
    }
}
