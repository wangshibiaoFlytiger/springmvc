package com.wangshibiao.spring.soapServer;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by Wang Shibiao on 2016/6/27.
 */
@WebService(name = "Helloworld", targetNamespace = "http://soapServer.spring.wangshibiao.com/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface Helloworld {
    @WebMethod
    String method1(String name);
}
