package com.hcid.partner.notification.service;

import com.hcid.partner.notification.entity.SMSQueue;

/**
 * Created by andry.sunandar01 on 30/01/2018.
 */
public interface SmsQueueService {
    void saveOrUpdate (SMSQueue smsQueue);
    SMSQueue getByDescription (String description);
}
