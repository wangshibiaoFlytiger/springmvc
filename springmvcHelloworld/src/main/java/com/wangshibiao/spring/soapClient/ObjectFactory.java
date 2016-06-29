
package com.wangshibiao.spring.soapClient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.wangshibiao.spring.soapClient package. 
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

    private final static QName _GetUserResponse_QNAME = new QName("http://soapService.spring.wangshibiao.com/", "getUserResponse");
    private final static QName _GetUser_QNAME = new QName("http://soapService.spring.wangshibiao.com/", "getUser");
    private final static QName _Method1_QNAME = new QName("http://soapService.spring.wangshibiao.com/", "method1");
    private final static QName _Method1Response_QNAME = new QName("http://soapService.spring.wangshibiao.com/", "method1Response");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.wangshibiao.spring.soapClient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetUserResponse }
     * 
     */
    public GetUserResponse createGetUserResponse() {
        return new GetUserResponse();
    }

    /**
     * Create an instance of {@link Method1 }
     * 
     */
    public Method1 createMethod1() {
        return new Method1();
    }

    /**
     * Create an instance of {@link GetUser }
     * 
     */
    public GetUser createGetUser() {
        return new GetUser();
    }

    /**
     * Create an instance of {@link Method1Response }
     * 
     */
    public Method1Response createMethod1Response() {
        return new Method1Response();
    }

    /**
     * Create an instance of {@link BaseModel }
     * 
     */
    public BaseModel createBaseModel() {
        return new BaseModel();
    }

    /**
     * Create an instance of {@link Org }
     * 
     */
    public Org createOrg() {
        return new Org();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapService.spring.wangshibiao.com/", name = "getUserResponse")
    public JAXBElement<GetUserResponse> createGetUserResponse(GetUserResponse value) {
        return new JAXBElement<GetUserResponse>(_GetUserResponse_QNAME, GetUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapService.spring.wangshibiao.com/", name = "getUser")
    public JAXBElement<GetUser> createGetUser(GetUser value) {
        return new JAXBElement<GetUser>(_GetUser_QNAME, GetUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Method1 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapService.spring.wangshibiao.com/", name = "method1")
    public JAXBElement<Method1> createMethod1(Method1 value) {
        return new JAXBElement<Method1>(_Method1_QNAME, Method1 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Method1Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapService.spring.wangshibiao.com/", name = "method1Response")
    public JAXBElement<Method1Response> createMethod1Response(Method1Response value) {
        return new JAXBElement<Method1Response>(_Method1Response_QNAME, Method1Response.class, null, value);
    }

}
