package com.wangshibiao.spring.soapServer;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by Wang Shibiao on 2016/6/27.
 */
@WebService(endpointInterface = "com.wangshibiao.spring.soapServer.Helloworld")
public class HelloworldImpl implements Helloworld{

    @Override
    public String method1(String name) {
        return "Hello "+name;
    }
}
