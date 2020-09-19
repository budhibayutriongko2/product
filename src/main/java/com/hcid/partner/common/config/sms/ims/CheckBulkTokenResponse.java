package com.hcid.partner.common.config.sms.ims;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Dinda.Wahyudi06
 */
@XmlRootElement(name = "bulk_token_response")
public class CheckBulkTokenResponse extends SmsResponse {

    private String currentToken;
    private String availableToken;
    private String reservedToken;

    public String getCurrentToken() {
        return currentToken;
    }

    @XmlElement(name = "current_token")
    public void setCurrentToken(String currentToken) {
        this.currentToken = currentToken;
    }

    public String getAvailableToken() {
        return availableToken;
    }

    @XmlElement(name = "available_token")
    public void setAvailableToken(String availableToken) {
        this.availableToken = availableToken;
    }

    public String getReservedToken() {
        return reservedToken;
    }

    @XmlElement(name = "reserved_token")
    public void setReservedToken(String reservedToken) {
        this.reservedToken = reservedToken;
    }

    @Override
    @XmlElement(name = "status_text")
    public void setMessage(String message) {
        super.setMessage(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    @XmlElement(name = "status_code")
    public void setCode(String code) {
        super.setCode(code);
    }

    @Override
    public String getCode() {
        return super.getCode();
    }
}
