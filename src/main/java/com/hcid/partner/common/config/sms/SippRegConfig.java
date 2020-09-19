package com.hcid.partner.common.config.sms;

/**
 * @author Dinda.Wahyudi06
 */
public class SippRegConfig {

    private String username;
    private String password;
    private String url;
    private String senderName;

    public SippRegConfig() {
    }

    public SippRegConfig(String username, String password, String url, String senderName) {
        this.username = username;
        this.password = password;
        this.url = url;
        this.senderName = senderName;
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
}
