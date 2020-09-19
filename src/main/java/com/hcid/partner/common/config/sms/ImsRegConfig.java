package com.hcid.partner.common.config.sms;

/**
 * @author dinda.wahyudi06
 */
public class ImsRegConfig {

    private String username;
    private String password;
    private String url;
    private String senderName;
    private String redirectUrl;
    private String allowDuplicate;
    private String priority;
    private String isLongSms;

    public ImsRegConfig() {
    }

    public ImsRegConfig(String username, String password, String url, String senderName, String redirectUrl, String allowDuplicate, String priority, String isLongSms) {
        this.username = username;
        this.password = password;
        this.url = url;
        this.senderName = senderName;
        this.redirectUrl = redirectUrl;
        this.allowDuplicate = allowDuplicate;
        this.priority = priority;
        this.isLongSms = isLongSms;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getAllowDuplicate() {
        return allowDuplicate;
    }

    public void setAllowDuplicate(String allowDuplicate) {
        this.allowDuplicate = allowDuplicate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getIsLongSms() {
        return isLongSms;
    }

    public void setIsLongSms(String isLongSms) {
        this.isLongSms = isLongSms;
    }
}
