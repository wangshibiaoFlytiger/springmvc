
package com.wangshibiao.spring.soapService.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "method1Response", namespace = "http://soapService.spring.wangshibiao.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "method1Response", namespace = "http://soapService.spring.wangshibiao.com/")
public class Method1Response {

    @XmlElement(name = "return", namespace = "")
    private String _return;

    /**
     * 
     * @return
     *     returns String
     */
    public String getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(String _return) {
        this._return = _return;
    }

}
