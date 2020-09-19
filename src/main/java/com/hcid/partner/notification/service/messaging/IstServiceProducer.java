package com.hcid.partner.notification.service.messaging;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hcid.partner.notification.dto.IstRequest;

@Service
public class IstServiceProducer {
	
	
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Value("${notification.ist.exchange}")
	String exchange;

	@Value("${notification.ist.routingkey}")
	private String routingkey;
	
	public void send(IstRequest request) {
		rabbitTemplate.convertAndSend(exchange, routingkey, request);
		System.out.println("Send msg = " + request);
	    
	}

}
