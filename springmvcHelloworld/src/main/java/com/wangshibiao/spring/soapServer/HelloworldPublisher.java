package com.wangshibiao.spring.soapServer;

import javax.xml.ws.Endpoint;

/**
 * Created by Wang Shibiao on 2016/6/27.
 */
public class HelloworldPublisher {
    public static void main(String[] args){
        Endpoint.publish("http://localhost:8081/ws/helloworld", new HelloworldImpl());
    }
}
