package com.hcid.partner.common.config.sms.ims;

import org.apache.commons.lang3.StringUtils;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author dinda.wahyudi06
 */
@XmlRootElement(name = "dn_data")
public class BulkSmsResponse {

    private String transactionId;
    private String code;
    private String message;
    private  String status;

    public BulkSmsResponse() {
    }

    public BulkSmsResponse(String code, String status, String message) {
//        super(code, status, message);
    }

    public String getCode() {
        return code;
    }

    @XmlElement(name = "error_code")
    public void setCode(String code) {
        this.code = code;
    }

    @XmlElement(name = "msisdn")
    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTransactionId() {
        return transactionId;
    }

    @XmlElement(name = "session_id")
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String toJsonString() {
        return "{"
                + ("transactionId:" + (StringUtils.isBlank(transactionId) ? null : transactionId) + ",")
                + ("code:" + (StringUtils.isBlank(code) ? null : code) + ",")
                + ("status:" + (StringUtils.isBlank(status) ? null : status) + ",")
                + ("message:" + (StringUtils.isBlank(message) ? null : message))
                + '}';
    }
}
