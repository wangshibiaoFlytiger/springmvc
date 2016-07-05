package com.wangshibiao.spring.AOP.aspectJ;

import com.wangshibiao.spring.BaseTest;
import com.wangshibiao.spring.dao.UserMapper;
import com.wangshibiao.spring.model.User;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Wang Shibiao on 2016/7/5.
 */
public class ControllerAspectTest extends BaseTest {
    @Resource
    RestTemplate restTemplate;

    @Test
    public void getUser(){
        Map user = restTemplate.getForObject("http://localhost:8080/user/{id}", Map.class, 181);
        Integer id = ((Double) user.get("id")).intValue();
        String username = (String) user.get("username");
    }
}
