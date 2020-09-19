package com.product.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.constant.GENERAL_CONSTANT;
import com.product.dto.Request;
import com.product.dto.Response;
import com.product.entity.Product;
import com.product.service.ProductService;
import com.product.service.SmsQueueService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/")
public class ProductController {

    @Autowired
    private ProductService productService;


 
    ObjectMapper mapper = new ObjectMapper();


    @PostMapping(value = "${api.productDetail}") 
    public ResponseEntity<Response> sendEmail(@RequestBody Request request) throws Exception{
        Response tippersResponse = new Response();
        try {
        	Product product = productService.getProductDetail(request);
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
