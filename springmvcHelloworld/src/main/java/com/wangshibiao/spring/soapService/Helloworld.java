package com.wangshibiao.spring.soapService;

import com.wangshibiao.spring.dao.UserMapper;
import com.wangshibiao.spring.model.User;
import com.wangshibiao.spring.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by Wang Shibiao on 2016/6/27.
 */

/**
 * 生成webservice剩余代码，执行命令：wsgen -wsdl -r F:\github\springmvc\springmvcHelloworld\src\main\resources\soap -s F:\github\springmvc\springmvcHelloworld\src\main\java -classpath F:\github\springmvc\out\build\springmvcHelloworld\classes\main\ com.wangshibiao.spring.soapService.Helloworld
 */
//@Service
@WebService
public class Helloworld {
    /*@Resource
    UserService userService;*/

    @WebMethod
    public String method1(String name){
        return "Hello "+name;
    }

    @WebMethod
    public User getUser(@WebParam(name = "username") String username){
        /*ApplicationContext applicationContext = new ClassPathXmlApplicationContext("mainCtx.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        User user = userService.getUserByUserName(username);*/
        User user = new User();
        user.setUsername("admin");
        user.setPassword("pass");
        //User user = userService.getUserByUserName("admin");
        return user;
    }
}
