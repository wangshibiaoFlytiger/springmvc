package com.wangshibiao.spring.soapService;

import com.wangshibiao.spring.dao.UserMapper;
import com.wangshibiao.spring.model.User;
import com.wangshibiao.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

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
 * 注意：执行wsgen之前先把extends SpringBeanAutowiringSupport注掉，执行完成后再恢复，否则命令提示错误
 */

@WebService
public class Helloworld extends SpringBeanAutowiringSupport{
    @Autowired
    UserService userService;

    @WebMethod
    public String method1(String name){
        return "Hello "+name;
    }

    @WebMethod
    public User getUser(@WebParam(name = "username") String username){
        User user = userService.getUserByUserName(username);
        return user;
    }
}
