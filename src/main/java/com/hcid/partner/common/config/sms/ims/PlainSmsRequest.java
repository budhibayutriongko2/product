package com.hcid.partner.common.config.sms.ims;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author dinda.wahyudi06
 */
@XmlRootElement(name = "mt_data")
public class PlainSmsRequest {

    private String messageType;
    private String username;
    private String password;
    private String priority;
    private String msisdn;
    private String msisdnSender;
    private String message;
    private String redirectUrl;

    public PlainSmsRequest() {
    }

    public String getMessageType() {
        return messageType;
    }

    @XmlElement(name = "msg_type")
    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getUsername() {
        return username;
    }

    @XmlElement(name = "username")
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    @XmlElement(name = "password")
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPriority() {
        return priority;
    }

    @XmlElement(name = "priority")
    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getMsisdn() {
        return msisdn;
    }

    @XmlElement(name = "msisdn")
    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getMsisdnSender() {
        return msisdnSender;
    }

    @XmlElement(name = "msisdn_sender")
    public void setMsisdnSender(String msisdnSender) {
        this.msisdnSender = msisdnSender;
    }

    public String getMessage() {
        return message;
    }

    @XmlElement(name = "message")
    public void setMessage(String message) {
        this.message = message;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    @XmlElement(name = "dr_url")
    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
}
