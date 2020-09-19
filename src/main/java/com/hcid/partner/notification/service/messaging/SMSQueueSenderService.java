package com.hcid.partner.notification.service.messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcid.partner.notification.config.GeneralConfig;
import com.hcid.partner.notification.dto.Request;
import com.hcid.partner.notification.dto.SendSmsMessagesRequest;
import com.hcid.partner.notification.utility.HelperUtil;

import net.homecredit.mss.domain.types.SmsMessageType;

import javax.jms.JMSException;
import javax.jms.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.stereotype.Service;

@Service
public class SMSQueueSenderService {
	
	@Value("${spring.wls.jms.message.sendSmsMessageQueue}")
    private String smsQueue;

    @Autowired
    private JmsTemplate jmsTemplate;
    
    @Autowired
    GeneralConfig config;

    ObjectMapper mapper = new ObjectMapper();

    public void sendSmsMessage(Request param) throws JsonProcessingException {
    	SendSmsMessagesRequest request = this.setSmsParam (param);
       jmsTemplate.convertAndSend(smsQueue, mapper.writeValueAsString(request), new MessagePostProcessor() {
           @Override
			public Message postProcessMessage(Message paramMessage) throws JMSException {
				paramMessage.setStringProperty("contentType", "application/json");
                return paramMessage;
			}
        });
    }
    
    private SendSmsMessagesRequest setSmsParam (Request request) {
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
