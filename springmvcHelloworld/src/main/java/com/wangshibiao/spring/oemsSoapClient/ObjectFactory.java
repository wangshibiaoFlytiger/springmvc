
package com.wangshibiao.spring.oemsSoapClient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.wangshibiao.spring.oemsSoapClient package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SmsSendSoapHeader_QNAME = new QName("http://tempuri.org/", "SmsSendSoapHeader");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.wangshibiao.spring.oemsSoapClient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SmsSend }
     * 
     */
    public SmsSend createSmsSend() {
        return new SmsSend();
    }

    /**
     * Create an instance of {@link MsgReceiveInfoResponse }
     * 
     */
    public MsgReceiveInfoResponse createMsgReceiveInfoResponse() {
        return new MsgReceiveInfoResponse();
    }

    /**
     * Create an instance of {@link ArrayOfString }
     * 
     */
    public ArrayOfString createArrayOfString() {
        return new ArrayOfString();
    }

    /**
     * Create an instance of {@link SmsSendSoapHeader }
     * 
     */
    public SmsSendSoapHeader createSmsSendSoapHeader() {
        return new SmsSendSoapHeader();
    }

    /**
     * Create an instance of {@link MsgSendReportStatusResponse }
     * 
     */
    public MsgSendReportStatusResponse createMsgSendReportStatusResponse() {
        return new MsgSendReportStatusResponse();
    }

    /**
     * Create an instance of {@link MsgSendReportStatus }
     * 
     */
    public MsgSendReportStatus createMsgSendReportStatus() {
        return new MsgSendReportStatus();
    }

    /**
     * Create an instance of {@link HelloWorldResponse }
     * 
     */
    public HelloWorldResponse createHelloWorldResponse() {
        return new HelloWorldResponse();
    }

    /**
     * Create an instance of {@link SmsSendResponse }
     * 
     */
    public SmsSendResponse createSmsSendResponse() {
        return new SmsSendResponse();
    }

    /**
     * Create an instance of {@link HelloWorld }
     * 
     */
    public HelloWorld createHelloWorld() {
        return new HelloWorld();
    }

    /**
     * Create an instance of {@link MsgReceiveInfo }
     * 
     */
    public MsgReceiveInfo createMsgReceiveInfo() {
        return new MsgReceiveInfo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SmsSendSoapHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "SmsSendSoapHeader")
    public JAXBElement<SmsSendSoapHeader> createSmsSendSoapHeader(SmsSendSoapHeader value) {
        return new JAXBElement<SmsSendSoapHeader>(_SmsSendSoapHeader_QNAME, SmsSendSoapHeader.class, null, value);
    }

}
