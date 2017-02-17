package com.wangshibiao.springbootdemo.controller;

import com.wangshibiao.springbootdemo.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by Wang Shibiao on 2017/2/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void testHome() throws Exception {

    }

    /**
     * 测试restful api: 添加某个用户/users
     * @throws Exception
     */
    @Test
    public void testAddUser() throws Exception {
        User user = new User();
        user.setName("lisi");
        user.setAge(44);

        String url = "http://localhost:8080/users";
        User userRet = restTemplate.postForObject(url, user, User.class);
    }

    /**
     * 测试restful api: 更新某个用户/users
     * @throws Exception
     */
    @Test
    public void testUpdateUser() throws Exception {
        User user = new User();
        user.setId("a9c359c5-f31b-11e6-a188-00ff3b946d39");
        user.setName("wangli_updated");
        user.setAge(44);

        String url = "http://localhost:8080/users";
        restTemplate.put(url, user, new Object());
    }

    /**
     * 测试restful api: 删除某个用户/users/{id}
     * @throws Exception
     */
    @Test
    public void testDeleteUser() throws Exception {
        String url = "http://localhost:8080/users/{id}";
        restTemplate.delete(url, "a9c359c5-f31b-11e6-a188-00ff3b946d39");
    }

    /**
     * 测试restful api: 查询某个用户/users/{id}
     * @throws Exception
     */
    @Test
    public void testGetUserById() throws Exception {
        String url1 = "http://localhost:8080/users/ade9759c-f34c-11e6-a188-00ff3b946d39";
        String url2 = "http://localhost:8080/users/{id}";

        //法1
        User user = restTemplate.getForObject(url1, User.class);
        //法2
        user = restTemplate.getForObject(url2, User.class, "ade9759c-f34c-11e6-a188-00ff3b946d39");
        //法3
        Map paras = new HashMap<>();
        paras.put("id", "ade9759c-f34c-11e6-a188-00ff3b946d39");
        user = restTemplate.getForObject(url2, User.class, paras);
        ResponseEntity<User> userResponseEntity = restTemplate.getForEntity(url2, User.class, paras);
    }

    /**
     * 测试restful api: 查询所有用户/users
     * @throws Exception
     */
    @Test
    public void testFindAllUsers() throws Exception {
        String url = "http://localhost:8080/users";
        List<User> userList = restTemplate.getForObject(url, List.class);
        //TODO:如下写法未通过
        // ResponseEntity<List<User>> userListResponseEntity = restTemplate.getForObject(url, List.class);
    }
}