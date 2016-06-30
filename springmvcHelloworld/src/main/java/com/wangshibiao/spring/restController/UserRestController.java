package com.wangshibiao.spring.restController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.wangshibiao.spring.model.User;
import com.wangshibiao.spring.service.UserService;
import org.apache.shiro.crypto.hash.Hash;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Created by Wang Shibiao on 2016/6/29.
 */
@RestController
public class UserRestController {
    @Resource
    UserService userService;

    @CrossOrigin("*")
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public Object addUser(User user){
        Integer isSuccess = userService.addUserModel(user);
        JsonObject jsonObject = new JsonObject();
        if (isSuccess == 1)
            jsonObject.addProperty("msg", "添加成功");
        else
            jsonObject.addProperty("msg", "添加失败");
        return jsonObject;
    }

    @CrossOrigin("*")
    @RequestMapping(value = "/user/{id:\\d+}", method = RequestMethod.DELETE)
    public Object deleteUser(@PathVariable("id") int id){
        Integer isSuccess = userService.delById(id);
        JsonObject jsonObject = new JsonObject();
        if (isSuccess == 1)
            jsonObject.addProperty("msg", "删除成功");
        else
            jsonObject.addProperty("msg", "删除失败");
        return jsonObject;
    }

    @CrossOrigin("*")
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public Object updateUser(User user){
        Integer isSuccess = userService.updateUser(user);
        JsonObject jsonObject = new JsonObject();
        if (isSuccess == 1)
            jsonObject.addProperty("msg", "更新成功");
        else
            jsonObject.addProperty("msg", "更新失败");
        return jsonObject;
    }

    @CrossOrigin("*")
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getAllUser(){
        List<User> userList = userService.findAll();

        //置空User对象的懒加载属性，否则json转换失败
        for (Iterator<User> iterator = userList.iterator(); iterator.hasNext();){
            User user = iterator.next();
            user.setOrg(null);
        }

        String userListJson = JSON.toJSONString(userList);
        return userListJson;
    }

    @CrossOrigin("*")
    @RequestMapping(value = "/user/{id:\\d+}", method = RequestMethod.GET)
    public User getUser(@PathVariable("id") int id){
        User user = userService.findById(id);
        return user;
    }
}
