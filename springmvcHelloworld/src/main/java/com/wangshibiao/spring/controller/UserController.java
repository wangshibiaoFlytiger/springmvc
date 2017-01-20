package com.wangshibiao.spring.controller;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.wangshibiao.spring.model.User;
import com.wangshibiao.spring.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    /**
     * 接口样例：http://localhost:8080/user/getUser.json?username=admin&token=123
     * @param request
     * @param response
     * @param username
     */
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

    /**
     * 获取用户列表接口：
     * 接口样例：http://localhost:8080/user/userList.json?token=123
     * @param request
     * @param response
     * @param pageNum   第几页
     * @param pageSize 每页记录数
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user/userList.json", method = RequestMethod.GET)
    public String getUserList(HttpServletRequest request, HttpServletResponse response,
                              @RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "1") Integer pageSize){
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

    /**
     * 将数据渲染到jsp页面
     * 访问地址样例：http://localhost:8080/user/testpage.html?token=123
     * @return
     */
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

    /**
     * 用户登录接口：
     * 输入账号和密码，如果是数据库中的正确用户则完成登录操作。否则用户认证失败，返回错误信息
     * 接口样例：http://localhost:8080/user/login.json?username=admin&password=admin&token=123
     * @param request
     * @param response
     * @param username
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user/login.json", method = RequestMethod.GET)
    public String login(HttpServletRequest request, HttpServletResponse response,
                      String username,
                      String password){
        //存储客户端输入的账号密码信息
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        //shiro执行登录逻辑，进行用户有效性验证(进入MyShiroRealm的doGetAuthenticationInfo方法)
        subject.login(usernamePasswordToken);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("ret", "success");
        return jsonObject.toString();
    }

    /**
     * 用户登出接口：
     * 销毁认证授权信息
     * 接口样例：http://localhost:8080/user/logout.json?token=123
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user/logout.json", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response){
        Subject subject = SecurityUtils.getSubject();
        SecurityUtils.getSecurityManager().logout(subject);
        return "注销成功";
    }
}
