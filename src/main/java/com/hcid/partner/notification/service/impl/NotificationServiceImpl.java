package com.hcid.partner.notification.service.impl;


import com.hcid.partner.common.config.sms.ims.SmsGatewayRequest;
import com.hcid.partner.notification.config.EndpointConfig;
import com.hcid.partner.notification.config.GeneralConfig;
import com.hcid.partner.notification.constant.GENERAL_CONSTANT;
import com.hcid.partner.notification.dto.*;
import com.hcid.partner.notification.entity.SMSQueue;
import com.hcid.partner.notification.service.NotificationService;
import com.hcid.partner.notification.service.SmsQueueService;
import com.hcid.partner.notification.utility.ConnectorUtil;
import com.hcid.partner.notification.utility.HeaderRequestInterceptor;
import com.hcid.partner.notification.utility.HelperUtil;
import net.homecredit.mss.domain.types.PriorityType;
import net.homecredit.mss.domain.types.ReportContentType;
import net.homecredit.mss.domain.types.ReportLevel;
import net.homecredit.mss.domain.types.SmsMessageType;
import net.homecredit.mss.ws.SendSmsMessageWS.SendSmsMessageWS;
import net.homecredit.mss.ws.SendSmsMessageWS.SendSmsMessageWSProxy;
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
public class NotificationServiceImpl implements NotificationService {

	private static final String API = "api/";
	private static final Logger log = LogManager.getLogger(NotificationServiceImpl.class);

	@Autowired
	GeneralConfig generalConfig;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	EndpointConfig endpointConfig;
	
	@SuppressWarnings("rawtypes")
    @Autowired
	XmlHelper xmlHelper;

	@Autowired
	SmsQueueService smsQueueService;

	@Override
	public void sendEmail (Request request) throws Exception {
		User user = request.getUser();
		String [] email = {user.getEmail()};
		this.sendEmailMessage(email,request.getSubject(),request.getEmailContent(), user);
	}
	
	private void sendEmailMessage(String[] to, String subject, String text, User user) throws Exception{
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		MimeMessage message = null;
		MimeMessageHelper helper = null;

		try {
			System.setProperty("smtp.host.name", generalConfig.getEmailHost());
			System.setProperty("smtp.port", generalConfig.getEmailPort().toString());
			System.setProperty("smtp.username", generalConfig.getEmailUsername());
			System.setProperty("smtp.password", generalConfig.getEmailPass());
	
			sender.setHost(generalConfig.getEmailHost());
			sender.setPort(generalConfig.getEmailPort());
			sender.setUsername(generalConfig.getEmailUsername());
			sender.setPassword(generalConfig.getEmailPass());
	
			message = sender.createMimeMessage();
			helper = new MimeMessageHelper(message, true);
			
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setFrom(generalConfig.getEmailFrom());

			helper.setText(text, true);
		        
			sender.send(message);
		} catch (MessagingException e) {
	  	 	throw new IllegalArgumentException(e.getMessage());
		}
	}

	@Override
	public SMSQueue sendSmsMSS(Request request) {
		SMSQueue sms2  = new SMSQueue();
		SMSQueue sms  = new SMSQueue();
		Date date = new Date();
		try {
			sms.setCreatedBy("SYSTEM");
			sms.setCreatedDate(date);
			sms.setUpdatedBy("SYSTEM");
			sms.setUpdatedDate(date);
			sms.setIsSend("N");
			sms.setRetryNumber(0);
			sms.setDescription(request.getSmsContent());
			smsQueueService.saveOrUpdate(sms);
			this.sendSmsWithMSS(request);
			sms2 = smsQueueService.getByDescription(request.getSmsContent());
		}catch (Exception e){
			log.error(e.getMessage());
		}
		return sms2;
	}

	@Override
	public SMSQueue sendSmsIMS(Request request) throws Exception {
		SMSQueue sms2  = new SMSQueue();
		try {
			sms2 = smsQueueService.getByDescription(request.getSmsContent());
			this.sendSmsWithIMS(request);
		}catch (Exception e){
			log.error(e.getMessage());
		}
		return sms2;
	}

	private void sendSmsWithMSS(Request request) throws Exception {
		try {
			this.sendSMS(new SmsRequest(request.getPhoneNumber(), request.getContent(), null), request.getTimeout());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	private void sendSMS(SmsRequest request, Integer timeout)throws Exception{
	  	SendSmsMessageWS sms = null;
	  	try {
	  		sms = new SendSmsMessageWSProxy();
	  		sms.sendSmsMessages(this.setSmsMessageTypeArr(generalConfig, request), this.setMSSParameters(generalConfig, timeout));
	  	} catch (Exception e) {
	  		throw new Exception(e.getMessage());
	  	}
	}
	
	private Map <String, Object> setMSSParameters (GeneralConfig config, Integer timeout){
	  	Map<String, Object> param = new HashMap<>();
	  	param.put("username", config.getWsUsername());
	  	param.put("pass", config.getWsPassword());
	  	param.put("endpoint", config.getWsMSSMessageURL());
	  	param.put("timeout", timeout);
	  	return param;
	  }
	
	private SmsMessageType [] setSmsMessageTypeArr (GeneralConfig config, SmsRequest request){
	  	SmsMessageType[] smsRequest = new SmsMessageType [1];
	  	smsRequest[0] = this.setSmsMessageType(config, request);
	  	return smsRequest;
	}
	 
	private SmsMessageType setSmsMessageType(GeneralConfig config, SmsRequest request){
	  	SmsMessageType smsMessageType = new SmsMessageType();
	  	smsMessageType.setExternalId("PP" + HelperUtil.getAbsoluteDate());
	  	smsMessageType.setSystemCode(config.getMssSystemCode());
	  	smsMessageType.setMessageCode(config.getMssMessageCode());
	  	
	  	smsMessageType.setReportContentType(ReportContentType.JSON);
	  
	  	smsMessageType.setRecipient(request.getPhoneNumber());
	  	smsMessageType.setText(request.getContent());
	  	return smsMessageType;
	}

	private void sendSmsWithIMS(Request request) throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("code", "IMS_GATEWAY");
		Map<String, Object> result =(Map<String, Object>) ConnectorUtil.postC(endpointConfig.getUrlEnvironment() + endpointConfig.getUtilContextRoot() + "api/"+endpointConfig.getGetCode(), param);
		List <Map<String, Object>> data =(List <Map<String, Object>>) result.get("object"); 
		Map<String, String> configConnection = this.convertCategoryToMapString(data);
		try {
			this.sendSMS(configConnection, new SmsRequest(request.getPhoneNumber(), request.getContent(), null), request.getTimeout());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	private Map<String, String> convertCategoryToMapString(List<Map<String, Object>> data){
	   	Map<String,String> result = new HashMap<String,String>();
	   	if(data!=null){
			 for (Map<String, Object> gp: data) {
			 	result.put(gp.get("param").toString(),gp.get("value").toString());
			 }
	   	}
	   	return result;
	}

	private void sendSMS(Map<String, String> config, SmsRequest request,Integer timeout) throws IOException {
		this.sendSMSWithSMSGateway(config, this.convertSmsReqToSMSGatewayReq(config, request), timeout);
	}
	
	private SmsGatewayRequest convertSmsReqToSMSGatewayReq(Map<String, String> config, SmsRequest request){
	  	SmsGatewayRequest req = new SmsGatewayRequest();
	  	req.setMsg_type("txt");
	  	req.setUsername(config.get("username"));
	  	req.setPriority("5");
	  	req.setPassword(config.get("password"));
	  	req.setMsisdn(request.getPhoneNumber());
	  	req.setMessage(request.getContent());
	  	req.setMsisdn_sender(config.get("sender"));
	  	req.setDr_url(config.get("url_recv"));
	  	return req;
	}
	
	@SuppressWarnings("unchecked")
	public void sendSMSWithSMSGateway(Map<String, String> config, SmsGatewayRequest request, Integer timeout) throws IOException {
		URL url = new URL(config.get("url"));
		String xmlString = xmlHelper.getXmlString(request).replace("\r\n   ", "").replace("\r\n", "");
		doSetProxy();
		String myParam = "data=" + URLEncoder.encode(xmlString, "UTF-8");
		this.exchange(url, myParam, timeout);
	}
	
	private void doSetProxy() {
		System.setProperty("java.net.useSystemProxies", "true");
		System.getProperties().put("http.proxyHost", "proxy.homecredit.id");
		System.getProperties().put("http.proxyPort", "3128");
	
		Authenticator.setDefault(new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(generalConfig.getProxyUser(), generalConfig.getProxyPas().toCharArray());
			}
		});
	}

	private void exchange(URL url, String param, Integer timeout) throws IOException {
	  	Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.homecredit.id", 3128));
	  	HttpURLConnection httpConn = (HttpURLConnection)url.openConnection(proxy);
	  	httpConn.setRequestMethod("POST");
	  	httpConn.setRequestProperty("Content-Type", MediaType.APPLICATION_FORM_URLENCODED.toString());
	  	httpConn.setRequestProperty("Content-Length", Integer.toString(param.length()));
	  	httpConn.setConnectTimeout(timeout);
	  	httpConn.setReadTimeout(timeout);
	  	httpConn.setDoOutput(true);
	
	  	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(httpConn.getOutputStream()));
	  	writer.write(param, 0, param.length());
	  	writer.flush();
	
	  	BufferedReader br = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
	  	StringBuilder sb = new StringBuilder();
	  	String output;
	  	while ((output = br.readLine()) != null) {
	  		sb.append(output);
	  	}
	  	br.close();
	}

	@Override
	public FirebaseResponse sendNotificationIncentive() throws Exception {
		FirebaseResponse firebaseResponse  = new FirebaseResponse();
		Map<String, Object>response = ConnectorUtil.postA(endpointConfig.getUrlEnvironment() + endpointConfig.getIncentiveContextRoot() + API +endpointConfig.getTippersAllDailyIncentive(), null);
		List<Map<String, Object>> object = (List<Map<String, Object>>) response.get(GENERAL_CONSTANT.OBJECT);
           
		List<String> tippersCode = new ArrayList<>();
		for(Map<String, Object> data : object) {
			tippersCode.add(data.get("tippersCode").toString());
		}

		Map<String, Object> param = new HashMap<>();
		param.put("listTippersCode", tippersCode);
           
		Map<String, Object> response2 = ConnectorUtil.postA(endpointConfig.getUrlEnvironment() + endpointConfig.getCoreContextRoot() + API + endpointConfig.getListDeviceIdIncentive(), param);
		List<String> listDeviceToken = (List<String>) response2.get(GENERAL_CONSTANT.OBJECT);

		CompletableFuture<FirebaseResponse> pushNotification = this.sendNotificationBySpecificOrIncentive(setFirebaseSpecificOrIncentive(listDeviceToken, null, 0));
		CompletableFuture.allOf(pushNotification).join();
		try {
			firebaseResponse = pushNotification.get();
		} catch (InterruptedException | ExecutionException e) {
			throw new IllegalArgumentException(e.getMessage());
		}
		return firebaseResponse;
	}

	@Override
	public FirebaseResponse sendNotificationSpecific(Request request) throws Exception {
		FirebaseResponse firebaseResponse  = new FirebaseResponse();
		Map<String, Object> param = new HashMap<>();

		param.put("listUser", request.getListUser());
		Map<String, Object> response = ConnectorUtil.postA(endpointConfig.getUrlEnvironment() + endpointConfig.getCoreContextRoot() + API + endpointConfig.getListDeviceIdEmailOrPhoneNumber(), param);
		List<String> listDeviceToken = (List<String>) response.get(GENERAL_CONSTANT.OBJECT);

		CompletableFuture<FirebaseResponse> pushNotification = this.sendNotificationBySpecificOrIncentive(setFirebaseSpecificOrIncentive(listDeviceToken, request, 1));
		CompletableFuture.allOf(pushNotification).join();
		try {
			firebaseResponse = pushNotification.get();
		} catch (InterruptedException | ExecutionException e) {
			throw new IllegalArgumentException(e.getMessage());
		}
		return firebaseResponse;
	}

	private FirebaseSpecificOrIncentive setFirebaseSpecificOrIncentive(List<String> listDeviceToken, Request request, int flag) throws Exception {
		FirebaseSpecificOrIncentive firebaseSpecificOrIncentive = new FirebaseSpecificOrIncentive();
		Notification notification1 = new Notification();
		Data data = new Data();
		Apns apns = new Apns();
		Payload payload = new Payload();
		Aps aps = new Aps();
		Android android = new Android();
		Notification notification2 = new Notification();

		if (flag == 0){
			firebaseSpecificOrIncentive.setRegistration_ids(listDeviceToken);
			firebaseSpecificOrIncentive.setPriority("high");
			notification1.setBody("");
			notification1.setTitle("");
			firebaseSpecificOrIncentive.setNotification(notification1);

			data.setClickAction("FLUTTER_NOTIFICATION_CLICK");
			data.setBody("");
			data.setTitle("");
			data.setTimestamp(String.valueOf(new Timestamp(new Date().getTime())));
			firebaseSpecificOrIncentive.setData(data);

			apns.setPayload(payload);
			payload.setAps(aps);
			aps.setSound("default");
			firebaseSpecificOrIncentive.setApns(apns);

			android.setPriority("high");
			notification2.setSound("default");
			android.setNotification(notification2);
			firebaseSpecificOrIncentive.setAndroid(android);

			return firebaseSpecificOrIncentive;
		}else {
			firebaseSpecificOrIncentive.setRegistration_ids(listDeviceToken);
			firebaseSpecificOrIncentive.setPriority("high");
			notification1.setBody(request.getDescription());
			notification1.setTitle(request.getTitle());
			firebaseSpecificOrIncentive.setNotification(notification1);

			data.setClickAction("FLUTTER_NOTIFICATION_CLICK");
			data.setBody(request.getDescription());
			data.setTitle(request.getTitle());
			data.setTimestamp(String.valueOf(new Timestamp(new Date().getTime())));
			firebaseSpecificOrIncentive.setData(data);

			apns.setPayload(payload);
			payload.setAps(aps);
			aps.setSound("default");
			firebaseSpecificOrIncentive.setApns(apns);

			android.setPriority("high");
			notification2.setSound("default");
			android.setNotification(notification2);
			firebaseSpecificOrIncentive.setAndroid(android);

			return firebaseSpecificOrIncentive;
		}
	}

	@Async
	public CompletableFuture<FirebaseResponse> sendNotificationBySpecificOrIncentive(FirebaseSpecificOrIncentive specificOrIncentive) {
		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();

		interceptors.add(new HeaderRequestInterceptor("Authorization", "key=" + generalConfig.getFirebaseServerKey()));
		interceptors.add(new HeaderRequestInterceptor("Content-Type", "application/json"));
		restTemplate.setInterceptors(interceptors);

		FirebaseResponse firebaseResponse = restTemplate.postForObject(generalConfig.getFirebaseApiUrl(), specificOrIncentive, FirebaseResponse.class);

		return CompletableFuture.completedFuture(firebaseResponse);
	}
}
