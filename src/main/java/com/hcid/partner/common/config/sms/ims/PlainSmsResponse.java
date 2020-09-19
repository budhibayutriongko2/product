package com.hcid.partner.common.config.sms.ims;

/**
 * @author dinda.wahyudi06
 */
public class PlainSmsResponse extends SmsResponse {

    public PlainSmsResponse() {
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
        this.status = getStatus();
    }

    @Override
    public String getStatus() {
        if (status != null) {
            return status;
        }
        if (code.equalsIgnoreCase("6801")) {
            return "The gateway successfully received the MT request";
        }
        if (code.equalsIgnoreCase("6802")) {
            return "Access Denied, IP Address not accepted";
        }
        if (code.equalsIgnoreCase("6803")) {
            return "Error, no parameters found";
        }
        if (code.equalsIgnoreCase("6804")) {
            return "Error, some parameters missing";
        }
        if (code.equalsIgnoreCase("6805")) {
            return "Error, invalid user credential";
        }
        if (code.equalsIgnoreCase("6806")) {
            return "Error, tariff code invalid or tariff code not assigned";
        }
        if (code.equalsIgnoreCase("6807")) {
            return "Error, Invalid Session ID / Session ID expired";
        }
        return null;
    }

    @Override
    public void setStatus(String message) {
        this.status = message;
    }
}
