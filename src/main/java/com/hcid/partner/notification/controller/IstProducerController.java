package com.hcid.partner.notification.controller;

import com.hcid.partner.notification.constant.GENERAL_CONSTANT;
import com.hcid.partner.notification.dto.IstRequest;
import com.hcid.partner.notification.dto.TippersResponse;
import com.hcid.partner.notification.service.messaging.IstServiceProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/")
public class IstProducerController {

    @Autowired
    private IstServiceProducer istServiceProducer;


    @PostMapping(value = "${api.sendToIst}") 
    public ResponseEntity<TippersResponse> sendToIst(@RequestBody IstRequest request) throws Exception{
        TippersResponse tippersResponse = new TippersResponse();
        try {
        	istServiceProducer.send(request);
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

   
}
