package com.hcid.partner.common.config.sms.ims;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author dinda.wahyudi06
 */
@XmlRootElement(name = "list_delivery_notice")
public class DeliveryNoticeResponse extends SmsResponse {

    private List<DataDelivery> dataDelivery;

    public DeliveryNoticeResponse() {
    }

    public DeliveryNoticeResponse(String code, String status, String message) {
        super(code, status, message);
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    @XmlElement(name = "status_code")
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    @XmlElement(name = "status_text")
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }

    public List<DataDelivery> getDataDelivery() {
        return dataDelivery;
    }

    @XmlElementWrapper(name = "list_data")
    @XmlElement(name = "data_delivery")
    public void setDataDelivery(List<DataDelivery> dataDelivery) {
        this.dataDelivery = dataDelivery;
    }

    @Override
    public String toJsonString() {
        return "{"
                + ("dataDelivery:" + getJsonString(dataDelivery))
                + '}';
    }

    private String getJsonString(List<DataDelivery> datas) {
        if (datas == null || datas.isEmpty())
            return "[]";

        String output = "";
        for (int i = 0; i < datas.size(); i++) {
            output += datas.get(i).toJsonString();
            if (i != datas.size() - 1) {
                output += ", ";
            }
        }
        return output;
    }
}
