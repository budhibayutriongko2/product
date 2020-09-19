package com.hcid.partner.common.config.sms.ims;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author dinda.wahyudi06
 */
@XmlRootElement(name = "list_delivery_notice")
public class DeliveryNoticeRequest extends Credential {

    private String date;
    private String transactionId;
    private String msisdn;
    private String sender;

    public DeliveryNoticeRequest() {
    }

    public DeliveryNoticeRequest(String username, String password) {
        super(username, password);
    }

    @Override
    @XmlElement(name = "username")
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getUsername() {
        return super.getUsername(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @XmlElement(name = "password")
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getPassword() {
        return super.getPassword(); //To change body of generated methods, choose Tools | Templates.
    }

    public String getDate() {
        return date;
    }

    @XmlElement(name = "date")
    public void setDate(String date) {
        this.date = date;
    }

    public String getTransactionId() {
        return transactionId;
    }

    @XmlElement(name = "transaction_id")
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getMsisdn() {
        return msisdn;
    }

    @XmlElement(name = "msisdn")
    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getSender() {
        return sender;
    }

    @XmlElement(name = "sender")
    public void setSender(String sender) {
        this.sender = sender;
    }

    @Override
    public String toString() {
        return "DeliveryNoticeRequest{" + "date=" + date
                + ", transactionId=" + transactionId
                + ", msisdn=" + msisdn
                + ", sender=" + sender + '}';
    }
}
