package com.wangshibiao.spring.soapClient;

import com.wangshibiao.spring.BaseTest;
import org.junit.Test;

import javax.xml.namespace.QName;
import javax.xml.ws.Holder;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Wang Shibiao on 2016/6/27.
 */
public class SoapClientTest extends BaseTest{
    //访问soap服务
    @Test
    public void soapClient() throws MalformedURLException {
        URL url = new URL("http://localhost:8081/ws/helloworld?wsdl");
        QName qName = new QName("http://soapServer.spring.wangshibiao.com/", "HelloworldImplService");
        Service service = Service.create(url, qName);
        Helloworld helloworld = service.getPort(Helloworld.class);
        System.out.println(helloworld.method1("good"));
    }

    /**
     * 通过wsimport生成的客户端代码访问soap服务,
     * 生成客户端代码的命令：wsimport -s F:\github\springmvc\springmvcHelloworld\src\main\java -p com.wangshibiao.spring.soapClient http://localhost:8081/ws/helloworld?wsdl
     */
    @Test
    public void soapClientWsimport(){
        HelloworldImplService helloworldImplService = new HelloworldImplService();
        Helloworld helloworld = helloworldImplService.getHelloworldImplPort();
        System.out.println(helloworld.method1("good"));
    }
}
