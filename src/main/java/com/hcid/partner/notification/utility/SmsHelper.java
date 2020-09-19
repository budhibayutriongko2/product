package com.hcid.partner.notification.utility;


import net.homecredit.mss.domain.types.SmsMessageType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hcid.partner.notification.config.GeneralConfig;
import com.hcid.partner.notification.dto.Request;
import com.hcid.partner.notification.dto.SendSmsMessagesRequest;

@Component
public class SmsHelper {
	
	@Autowired
	GeneralConfig config;

    public SendSmsMessagesRequest getSendSmsMessagesRequest(Request request) {
        SmsMessageType smsMessageType = new SmsMessageType();
        smsMessageType.setExternalId("PP" + HelperUtil.getAbsoluteDate());
        smsMessageType.setSystemCode(config.getMssSystemCode());
        smsMessageType.setMessageCode(config.getMssMessageCode());
        smsMessageType.setPriority("IMMEDIATE");
        smsMessageType.setReportLevel("NONE");
        smsMessageType.setRecipient(request.getPhoneNumber());
        smsMessageType.setText(request.getSmsContent());
        smsMessageType.setIsInteractive(false);

        SendSmsMessagesRequest param = new SendSmsMessagesRequest();
        param.getMessage().add(smsMessageType);
        return param;
    }
}
