package com.hcid.partner.common.config.sms.ims;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author dinda.wahyudi06
 */
@XmlRootElement(name = "packet")
public class Packet {

    private String msisdn;
    private String sms;
    private String isLongSms;

    public Packet() {
    }

    public Packet(String msisdn, String sms, String isLongSms) {
        this.msisdn = msisdn;
        this.sms = sms;
        this.isLongSms = isLongSms;
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

    public String getIsLongSms() {
        return isLongSms;
    }

    @XmlElement(name = "is_long_sms")
    public void setIsLongSms(String isLongSms) {
        this.isLongSms = isLongSms;
    }

    @Override
    public String toString() {
        return "Packet{"
                + "msisdn=" + msisdn
                + ", ims=" + sms
                + ", isLongSms=" + isLongSms
                + '}';
    }
}
