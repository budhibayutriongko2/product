package com.hcid.partner.common.config.sms.ims;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by acc.iqbalnurcahyadi on 03/05/2017.
 */

@XmlRootElement(name = "mt_data")
@XmlAccessorType(XmlAccessType.FIELD)
public class SmsGatewayRequest implements Serializable {


    @XmlElement
    private String msg_type;

    @XmlElement
    private String username;

    @XmlElement
    private String password;

    @XmlElement
    private String priority;

    @XmlElement
    private String msisdn_sender;

    @XmlElement
    private String msisdn;

    @XmlElement
    private String message;

    @XmlElement
    private String dr_url;

    public SmsGatewayRequest() {

    }


    public SmsGatewayRequest(String uname, String pass, String type, String sender, String to, String message, String url) {
        this.setMsg_type("txt");
        this.setUsername(uname);
        this.setPassword(pass);
        switch (type) {
            case "OTP":
                this.setPriority("5");
                break;
            default:
                this.setPriority("1");
                break;
        }
        this.setMsisdn_sender(sender);
        this.setMsisdn(to);
        this.setMessage(message);
        this.setDr_url(url);
    }


    public String getMsg_type() {
        return msg_type;
    }

    public void setMsg_type(String msg_type) {
        this.msg_type = msg_type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getMsisdn_sender() {
        return msisdn_sender;
    }

    public void setMsisdn_sender(String msisdn_sender) {
        this.msisdn_sender = msisdn_sender;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDr_url() {
        return dr_url;
    }

    public void setDr_url(String dr_url) {
        this.dr_url = dr_url;
    }
}
