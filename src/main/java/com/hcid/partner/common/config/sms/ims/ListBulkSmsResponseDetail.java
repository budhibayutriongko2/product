package com.hcid.partner.common.config.sms.ims;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Dinda.Wahyudi06
 */
@XmlRootElement(name = "request_bulk")
public class ListBulkSmsResponseDetail {

    private String code;
    private String message;
    private String date;
    private String transactionId;
    private String priority;
    private String sender;
    private String redirectUrl;

    public ListBulkSmsResponseDetail() {
    }

    public String getCode() {
        return code;
    }

    @XmlElement(name = "request_status_code")
    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    @XmlElement(name = "request_status_text")
    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    @XmlElement(name = "request_date")
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

    public String getPriority() {
        return priority;
    }

    @XmlElement(name = "priority")
    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getSender() {
        return sender;
    }

    @XmlElement(name = "sender")
    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    @XmlElement(name = "dr_url")
    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
}
