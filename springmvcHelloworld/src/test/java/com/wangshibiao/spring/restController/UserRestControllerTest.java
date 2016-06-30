package com.wangshibiao.spring.restController;

import com.alibaba.fastjson.JSON;
import com.wangshibiao.spring.BaseTest;
import com.wangshibiao.spring.model.User;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Wang Shibiao on 2016/6/30.
 */
public class UserRestControllerTest extends BaseTest{
    @Resource
    RestTemplate restTemplate;

    //TODO: 没测试通过，测试代码有问题
    @Test
    public void addUser(){
        Map user = new HashMap<>();
        user.put("username", "restname1");
        restTemplate.postForObject("http://localhost:8080/user", null, Map.class, user);
    }

    @Test
    public void delUser(){
        restTemplate.delete("http://localhost:8080/user/{id}", 182);
    }

    //TODO: 没测试通过,测试代码有问题
    @Test
    public void updateUser(){
        Map userMap = new HashMap<>();
        userMap.put("username", "restname1");
        restTemplate.put("http://localhost:8080/user", userMap);
    }

    @Test
    public void getUser(){
        Map user = restTemplate.getForObject("http://localhost:8080/user/{id}", Map.class, 181);
        Integer id = ((Double) user.get("id")).intValue();
        String username = (String) user.get("username");
    }

    @Test
    public void getUserList(){
        List userList = restTemplate.getForObject("http://localhost:8080/user", List.class);
    }
}
