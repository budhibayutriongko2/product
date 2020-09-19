package com.hcid.partner.common.config.sms.ims;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author dinda.wahyudi06
 */
@XmlRootElement(name = "bulk_sending")
public class BulkSmsRequest extends Credential {

    private String priority;
    private String sender;
    private String redirectUrl;
    private String allowDuplicate;
    private List<Packet> dataPacket;

    public BulkSmsRequest() {
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

    public String getAllowDuplicate() {
        return allowDuplicate;
    }

    @XmlElement(name = "allowduplicate")
    public void setAllowDuplicate(String allowDuplicate) {
        this.allowDuplicate = allowDuplicate;
    }

    public List<Packet> getDataPacket() {
        return dataPacket;
    }

    @XmlElementWrapper(name = "data_packet")
    @XmlElement(name = "packet")
    public void setDataPacket(List<Packet> dataPacket) {
        this.dataPacket = dataPacket;
    }

    @Override
    public String toString() {
        return "BulkSmsRequest{" + "username=" + username
                + ", password=" + password
                + ", priority=" + priority
                + ", sender=" + sender
                + ", redirectUrl=" + redirectUrl
                + ", allowDuplicate=" + allowDuplicate
                + ", dataPacket=" + getString(dataPacket) + '}';
    }

    private String getString(List<Packet> packets) {
        if (packets == null || packets.isEmpty())
            return "{}";
        String output = "";
        for (Packet packet : packets) {
            output += packet.toString();
        }
        return output;
    }
}
