package com.hcid.partner.notification.service;

import com.hcid.partner.notification.dto.FirebaseResponse;
import com.hcid.partner.notification.dto.Request;
import com.hcid.partner.notification.entity.SMSQueue;

public interface NotificationService {
	void sendEmail (Request request) throws Exception;
	FirebaseResponse sendNotificationIncentive() throws Exception;
	FirebaseResponse sendNotificationSpecific(Request request) throws Exception;
	SMSQueue sendSmsMSS(Request request) throws Exception;
	SMSQueue sendSmsIMS(Request request) throws Exception;
}
