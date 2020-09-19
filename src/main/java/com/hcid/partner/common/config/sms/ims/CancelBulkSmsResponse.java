package com.hcid.partner.common.config.sms.ims;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Dinda.Wahyudi06
 */
@XmlRootElement(name = "cancel_transaction")
public class CancelBulkSmsResponse extends SmsResponse {

    private String description;
    private String transactionId;

    @Override
    @XmlElement(name = "status_code")
    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    @XmlElement(name = "description")
    public void setDescription(String description) {
        this.description = description;
    }

    public String getTransactionId() {
        return transactionId;
    }

    @XmlElement(name = "transaction_id")
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
