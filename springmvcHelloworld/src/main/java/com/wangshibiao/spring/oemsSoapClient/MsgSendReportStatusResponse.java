
package com.wangshibiao.spring.oemsSoapClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MsgSendReportStatusResult" type="{http://tempuri.org/}ArrayOfString" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "msgSendReportStatusResult"
})
@XmlRootElement(name = "MsgSendReportStatusResponse")
public class MsgSendReportStatusResponse {

    @XmlElement(name = "MsgSendReportStatusResult")
    protected ArrayOfString msgSendReportStatusResult;

    /**
     * 获取msgSendReportStatusResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getMsgSendReportStatusResult() {
        return msgSendReportStatusResult;
    }

    /**
     * 设置msgSendReportStatusResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setMsgSendReportStatusResult(ArrayOfString value) {
        this.msgSendReportStatusResult = value;
    }

}
