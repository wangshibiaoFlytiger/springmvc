package com.wangshibiao.spring.AOP.aspectJ;

import com.wangshibiao.spring.model.User;
import com.wangshibiao.spring.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.annotation.Resource;

/**
 * Created by Wang Shibiao on 2016/7/4.
 */
/**
 * 通过AspectJ创建aspect
 * 注意：更改java编译器为Ajc方可成功编译,Ajc编译器为aspectjtools.jar(已定义在工程依赖中)
 */
public aspect ControllerAspect extends SpringBeanAutowiringSupport{
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    UserService userService;

    public ControllerAspect() {
    }

    //拦截controller和restController包下的所有方法
    pointcut controllerMethod() : execution(* com.wangshibiao.spring.*ontroller..*.*(..));

    before() : controllerMethod(){
        User user = userService.getUserByUserName("admin");
        logger.debug("DaoAspect @Before:"+user.getUsername());
        logger.debug("DaoAspect @Before: ");
    }
}
