package com.hcid.partner.notification.controller;

import com.hcid.partner.notification.dto.FirebaseResponse;
import com.hcid.partner.notification.dto.IstRequest;
import com.hcid.partner.notification.entity.SMSQueue;
import com.hcid.partner.notification.service.SmsQueueService;
import com.hcid.partner.notification.service.messaging.IstServiceProducer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class IstControllerTest {

    @InjectMocks
    IstProducerController istProducerController;

    @Mock
    IstServiceProducer istServiceProducer;
    @Mock
    SmsQueueService smsQueueService;

    IstRequest request = new IstRequest();
    FirebaseResponse firebaseResponse = new FirebaseResponse();
    SMSQueue sms2  = new SMSQueue();

    @Test
    public void sendEmail_Success() throws Exception {
    	istServiceProducer.send(request);
    	istProducerController.sendToIst(request);
    }

    @Test
    public void sendEmail_Failed() throws Exception {
        Mockito.doNothing().doThrow(new Exception());
        istProducerController.sendToIst(request);
    }

   
}