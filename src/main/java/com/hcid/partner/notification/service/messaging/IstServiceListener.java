package com.hcid.partner.notification.service.messaging;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Service;

@Service
public class IstServiceListener implements MessageListener{	

	@Override
	public void onMessage(Message message) {
		System.out.println("#################  Consuming Message - " + new String(message.getBody()) + "#################  ");
		
	}

}
