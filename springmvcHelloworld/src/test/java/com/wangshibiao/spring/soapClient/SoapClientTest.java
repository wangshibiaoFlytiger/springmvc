package com.wangshibiao.spring.soapClient;

import com.sun.org.apache.xpath.internal.SourceTree;
import com.wangshibiao.spring.BaseTest;
import com.wangshibiao.spring.model.*;
import com.wangshibiao.spring.model.User;
import com.wangshibiao.spring.oemsSoapClient.OemsSmsService;
import com.wangshibiao.spring.oemsSoapClient.OemsSmsServiceSoap;
import com.wangshibiao.spring.oemsSoapClient.SmsSendSoapHeader;
import org.junit.Test;

import javax.annotation.Resource;
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
        HelloworldService helloworldService = new HelloworldService();
        Helloworld helloworld = helloworldService.getHelloworldPort();
        String ret = helloworld.method1("para1");
        com.wangshibiao.spring.soapClient.User user = helloworld.getUser("admin");
    }

    /**
     * 测试oems的soap service
     * 通过wsimport生成的客户端代码访问soap服务,
     * 生成客户端代码的命令：wsimport -XadditionalHeaders -s F:\github\springmvc\springmvcHelloworld\src\main\java -p com.wangshibiao.spring.oemsSoapClient http://116.213.120.55/OpenSMSWebService/OemsSmsService.asmx?wsdl
     */
    @Test
    public void oems(){
        String mobilephoneno = "15201592893";
        String msgTitle  ="title1";
        String msgContent = "content1";
        Holder<Integer> smsSendResult = new Holder<Integer>();
        Holder<String> smsReturnValue = new Holder<String>();
        SmsSendSoapHeader smsSendSoapHeader = new SmsSendSoapHeader();
        smsSendSoapHeader.setSendSource("oesspmcauth");
        smsSendSoapHeader.setSendSourcePwd("oesspmcauth-auth-pass-word-2016-0622");

        OemsSmsService oemsSmsService = new OemsSmsService();
        OemsSmsServiceSoap oemsSmsServiceSoap = oemsSmsService.getPort(OemsSmsServiceSoap.class);
        oemsSmsServiceSoap.smsSend(mobilephoneno, msgTitle, msgContent, smsSendResult, smsReturnValue, smsSendSoapHeader);
        Integer sendResult = smsSendResult.value;
        String returnValue = smsReturnValue.value;
    }

}
