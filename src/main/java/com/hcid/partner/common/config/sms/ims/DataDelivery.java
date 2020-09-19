package com.hcid.partner.common.config.sms.ims;

import org.apache.commons.lang3.StringUtils;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Dinda.Wahyudi06
 */
@XmlRootElement(name = "data_delivery")
public class DataDelivery {

    private String transactionId;
    private String referenceId;
    private String sender;
    private String msisdn;
    private String sms;
    private String dateSent;
    private String code;

    public DataDelivery() {
    }

    public String getTransactionId() {
        return transactionId;
    }

    @XmlElement(name = "transaction_id")
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getReferenceId() {
        return referenceId;
    }

    @XmlElement(name = "reference_id")
    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getSender() {
        return sender;
    }

    @XmlElement(name = "sender")
    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMsisdn() {
        return msisdn;
    }

    @XmlElement(name = "msisdn")
    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getSms() {
        return sms;
    }

    @XmlElement(name = "ims")
    public void setSms(String sms) {
        this.sms = sms;
    }

    public String getDateSent() {
        return dateSent;
    }

    @XmlElement(name = "sms_out_date")
    public void setDateSent(String dateSent) {
        this.dateSent = dateSent;
    }

    public String getCode() {
        return code;
    }

    @XmlElement(name = "status_code")
    public void setStatusCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        if (code.equals("3700")) return "Successfully received by SMSC (waiting for Mobile Ack)";
        if (code.equals("3701")) return "Successfully delivered to handset";
        if (code.equals("3702")) return "Insufficient balance";
        if (code.equals("3703")) return "Invalid MSISDN";
        if (code.equals("3704")) return "SMSC Internal Server Error";
        if (code.equals("3705")) return "Charging Error";
        if (code.equals("3706")) return "Message Session Expired";
        if (code.equals("3707")) return "MSISDN not subscribed to service";
        if (code.equals("3709")) return "Gateway Problem";
        if (code.equals("3710")) return "Gateway Timeout";
        if (code.equals("3711")) return "Delivery Notice(DR) waiting timeout";
        if (code.equals("3712")) return "SMSC Throttle Error";
        if (code.equals("3713")) return "SMSC Roaming";
        if (code.equals("3714")) return "Handset Error";
        if (code.equals("3750")) return "SMS Text Contain Invalid GSM Character";
        if (code.equals("3751")) return "SMS Text More Than 160 Character";
        if (code.equals("3774")) return "SMSC Internal Server Error";
        if (code.equals("3776")) return "Message Session Expired";
        if (code.equals("3777")) return "MSISDN not subscribed to service";
        return null;
    }

    public String toJsonString() {
        return "{\n"
                + ("transactionId:" + (StringUtils.isBlank(transactionId) ? null : transactionId) + ",\n")
                + ("referenceId:" + (StringUtils.isBlank(referenceId) ? null : referenceId) + ",\n")
                + ("sender:" + (StringUtils.isBlank(sender) ? null : sender) + ",\n")
                + ("msisdn:" + (StringUtils.isBlank(msisdn) ? null : msisdn) + ",\n")
                + ("ims:" + (StringUtils.isBlank(sms) ? null : sms) + ",\n")
                + ("dateSent:" + (StringUtils.isBlank(dateSent) ? null : dateSent) + ",\n")
                + ("code:" + (StringUtils.isBlank(code) ? null : code) + ",\n")
                + ("message:" + (StringUtils.isBlank(getMessage()) ? null : getMessage()) + "\n")
                + '}';
    }
}
