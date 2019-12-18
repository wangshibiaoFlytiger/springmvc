package com.wangshibiao.spring.controller;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.wangshibiao.spring.BaseTest;
import org.junit.Test;

/**
 * Created by Wang Shibiao on 2016/8/1.
 */
public class UserControllerTest extends BaseTest{
    /**
     * shiro配置的登录地址，用户完成“认证”操作
     * @throws UnirestException
     */
    @Test
    public void login() throws UnirestException {
        HttpResponse<JsonNode> jsonNodeHttpResponse = Unirest.get("http://localhost:8080/user/login.json")
                .header("accept", "application/json")
                .queryString("username", "admin")
                .queryString("password", "admin")
                .queryString("token", "123")
                .asJson();

        System.out.println(jsonNodeHttpResponse.getBody());
    }

    /**
     * 不受shiro权限控制
     * @throws UnirestException
     */
    @Test
    public void testpage() throws UnirestException {
        HttpResponse<JsonNode> jsonNodeHttpResponse = Unirest.get("http://localhost:8080/user/testpage.html")
                .header("accept", "application/json")
                .queryString("username", "admin")
                .queryString("token", "123")
                .asJson();

        System.out.println(jsonNodeHttpResponse.getBody());
    }

    /**
     * 只有通过shiro认证后，才允许访问该地址
     * @throws UnirestException
     */
    @Test
    public void getUser() throws UnirestException {
        HttpResponse<JsonNode> jsonNodeHttpResponse = Unirest.get("http://localhost:8080/user/getUser.json")
                .header("accept", "application/json")
                .queryString("username", "admin")
                .asJson();
    }

    /**
     * 只有通过shiro认证和授权后，才允许访问该地址
     * @throws UnirestException
     */
    @Test
    public void userList() throws UnirestException {
        HttpResponse<JsonNode> jsonNodeHttpResponse = Unirest.get("http://localhost:8080/user/userList.json")
                .header("accept", "application/json")
                .queryString("token", "123")
                //.queryString("username", "admin")
                .queryString("pageNum", "1")
                .queryString("pageSize", "10")
                .asJson();
    }

    /**
     * shiro注销
     * @throws UnirestException
     */
    @Test
    public void logout() throws UnirestException {
        HttpResponse<JsonNode> jsonNodeHttpResponse = Unirest.get("http://localhost:8080/user/logout.json")
                .header("accept", "application/json")
                .queryString("token", "123")
                .asJson();
    }
}
