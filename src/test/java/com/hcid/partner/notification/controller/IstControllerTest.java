package com.hcid.partner.notification.controller;

import com.product.controller.IstProducerController;
import com.product.dto.FirebaseResponse;
import com.product.dto.IstRequest;
import com.product.entity.Product;
import com.product.notification.service.messaging.IstServiceProducer;
import com.product.service.SmsQueueService;

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
    Product sms2  = new Product();

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