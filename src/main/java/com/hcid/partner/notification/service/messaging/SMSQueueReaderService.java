package com.hcid.partner.notification.service.messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcid.partner.notification.dto.DeliveryNotificationType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class SMSQueueReaderService {

    private static final Logger LOGGER = LogManager.getLogger(SMSQueueReaderService.class.getName());

    

    ObjectMapper mapper = new ObjectMapper();

    @JmsListener(destination = "jms.external.MssToPapo.queue")
    public void receiveMssAckMessageNotification(DeliveryNotificationType notification) throws JsonProcessingException {
        LOGGER.info("ACK : {}",mapper.writeValueAsString(notification));
    }
}
