package com.hcid.partner.notification.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcid.partner.notification.constant.GENERAL_CONSTANT;
import com.hcid.partner.notification.dto.Request;
import com.hcid.partner.notification.dto.TippersResponse;
import com.hcid.partner.notification.entity.SMSQueue;
import com.hcid.partner.notification.service.NotificationService;
import com.hcid.partner.notification.service.SmsQueueService;
import com.hcid.partner.notification.service.messaging.SMSQueueSenderService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;
    @Autowired
    private SmsQueueService smsQueueService;

    @Autowired
    private SMSQueueSenderService senderService;
 
    ObjectMapper mapper = new ObjectMapper();


    @PostMapping(value = "${api.sendEmail}") 
    public ResponseEntity<TippersResponse> sendEmail(@RequestBody Request request) throws Exception{
        TippersResponse tippersResponse = new TippersResponse();
        try {
        	notificationService.sendEmail(request);
            tippersResponse.setCode("00");
            tippersResponse.setDescription(GENERAL_CONSTANT.SUCCESS);
            tippersResponse.setObject(null);
        }catch (Exception e){
            tippersResponse.setCode("01");
            tippersResponse.setDescription(GENERAL_CONSTANT.FAILED);
            tippersResponse.setObject(e.getMessage());
        }
        return new ResponseEntity<>(tippersResponse, HttpStatus.OK);
    }

    @PostMapping(value = "${api.sendSMS}")
    public ResponseEntity<TippersResponse> sendSMS(@RequestBody Request request) throws Exception{
        TippersResponse tippersResponse = new TippersResponse();
    	SMSQueue sms2  = new SMSQueue();
        try {
        	sms2 = notificationService.sendSmsMSS(request);
            tippersResponse.setCode("00");
            tippersResponse.setDescription(GENERAL_CONSTANT.SUCCESS);
            tippersResponse.setObject(GENERAL_CONSTANT.SUCCESS);
        }catch (Exception e){
        	try {
                sms2 = notificationService.sendSmsIMS(request);
			} catch (Exception e2) {
        	    tippersResponse.setCode("01");
        	    tippersResponse.setDescription(GENERAL_CONSTANT.SUCCESS);
        	    tippersResponse.setObject(e2.getMessage());
			}
            tippersResponse.setCode("00");
            tippersResponse.setDescription(GENERAL_CONSTANT.SUCCESS);
            tippersResponse.setObject(e.getMessage());
        }finally {
            sms2.setIsSend("Y");
            smsQueueService.saveOrUpdate(sms2);
		}
        return new ResponseEntity<>(tippersResponse, HttpStatus.OK);
    }
    
   
  
    @PostMapping("/v2/sendSmsJms")
    public ResponseEntity<String> sendSmsJms(@RequestBody Request request) throws JsonProcessingException {
        
        senderService.sendSmsMessage(request);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping(value = "${api.pushNotification}")
    public ResponseEntity<TippersResponse> pushNotification() throws Exception{
        TippersResponse tippersResponse = new TippersResponse();
        try {
            tippersResponse.setCode("00");
            tippersResponse.setDescription(GENERAL_CONSTANT.SUCCESS);
            tippersResponse.setObject(notificationService.sendNotificationIncentive());

        }catch (Exception e){
            tippersResponse.setCode("01");
            tippersResponse.setDescription(GENERAL_CONSTANT.FAILED);
            tippersResponse.setObject(e.getMessage());
        }
        return new ResponseEntity<>(tippersResponse, HttpStatus.OK);
    }

    @PostMapping(value = "${api.sendNotification}")
    public ResponseEntity<TippersResponse> sendNotification(@RequestBody Request request) throws Exception{
        TippersResponse tippersResponse = new TippersResponse();
        try {
            tippersResponse.setCode("00");
            tippersResponse.setDescription(GENERAL_CONSTANT.SUCCESS);
            tippersResponse.setObject(notificationService.sendNotificationSpecific(request));
        }catch (Exception e){
            tippersResponse.setCode("01");
            tippersResponse.setDescription(GENERAL_CONSTANT.FAILED);
            tippersResponse.setObject(e.getMessage());
        }
        return new ResponseEntity<>(tippersResponse, HttpStatus.OK);
    }
}
