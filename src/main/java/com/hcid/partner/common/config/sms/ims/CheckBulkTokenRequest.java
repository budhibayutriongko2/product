package com.hcid.partner.common.config.sms.ims;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Dinda.Wahyudi06
 */
@XmlRootElement(name = "bulk_token")
public class CheckBulkTokenRequest extends Credential {

    public CheckBulkTokenRequest() {
    }

    public CheckBulkTokenRequest(String username, String password) {
        this.username = username;
        this.password = password;
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
}
