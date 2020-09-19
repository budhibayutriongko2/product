package com.hcid.partner.common.config.sms.ims;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * @author Dinda.Wahyudi06
 */
public class ListBulkSmsResponse extends SmsResponse {

    private List<ListBulkSmsResponseDetail> details;

    public ListBulkSmsResponse() {
    }

    @Override
    @XmlElement(name = "status_code")
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    @XmlElement(name = "status_text")
    public void setMessage(String message) {
        this.message = message;
    }

    public List<ListBulkSmsResponseDetail> getDetails() {
        return details;
    }

    @XmlElementWrapper(name = "list_request")
    @XmlElement(name = "request_bulk")
    public void setDetails(List<ListBulkSmsResponseDetail> details) {
        this.details = details;
    }
}
