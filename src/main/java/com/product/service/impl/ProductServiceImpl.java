package com.product.service.impl;


import com.product.config.EndpointConfig;
import com.product.config.GeneralConfig;
import com.product.constant.GENERAL_CONSTANT;
import com.product.dao.ProductDAO;
import com.product.dto.*;
import com.product.entity.Product;
import com.product.service.ProductService;
import com.product.utility.ConnectorUtil;
import com.product.utility.HeaderRequestInterceptor;
import com.product.utility.HelperUtil;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.net.*;
import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class ProductServiceImpl implements ProductService {


	@Autowired
	GeneralConfig generalConfig;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	ProductDAO productDAO;
	


	@Override
	public Product getProductDetail (Request request) throws Exception {
		return productDAO.findByProductCode(request.getProductCode());
	}
	
	
}
