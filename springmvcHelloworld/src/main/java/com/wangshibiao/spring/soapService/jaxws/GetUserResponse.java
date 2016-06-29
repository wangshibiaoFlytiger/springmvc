
package com.wangshibiao.spring.soapService.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getUserResponse", namespace = "http://soapService.spring.wangshibiao.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getUserResponse", namespace = "http://soapService.spring.wangshibiao.com/")
public class GetUserResponse {

    @XmlElement(name = "return", namespace = "")
    private com.wangshibiao.spring.model.User _return;

    /**
     * 
     * @return
     *     returns User
     */
    public com.wangshibiao.spring.model.User getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(com.wangshibiao.spring.model.User _return) {
        this._return = _return;
    }

}
