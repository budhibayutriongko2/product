package com.hcid.partner.common.config.sms.ims;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Dinda.Wahyudi06
 */
@XmlRootElement(name = "list_bulk")
public class ListBulkSmsRequest extends Credential {

    private String date;

    public ListBulkSmsRequest() {
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
}
