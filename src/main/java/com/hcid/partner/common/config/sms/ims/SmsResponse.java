package com.hcid.partner.common.config.sms.ims;

import org.apache.commons.lang3.StringUtils;

/**
 * @author dinda.wahyudi06
 */
public class SmsResponse {

    String code;
    String status;
    String message;

    public SmsResponse() {
    }

    public SmsResponse(String code, String status, String message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String toJsonString() {
        return "{"
                + ("code:" + (StringUtils.isBlank(code) ? null : code) + ",")
                + ("status:" + (StringUtils.isBlank(status) ? null : status) + ",")
                + ("message:" + (StringUtils.isBlank(message) ? null : message) + ",")
                + '}';
    }
}
