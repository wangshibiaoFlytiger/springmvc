package com.wangshibiao.spring.init;

import com.wangshibiao.spring.soapService.Helloworld;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.xml.ws.Endpoint;

/**
 * Created by Wang Shibiao on 2016/6/29.
 */
public class InitListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Endpoint.publish("http://localhost:8081/ws/helloworld", new Helloworld());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
