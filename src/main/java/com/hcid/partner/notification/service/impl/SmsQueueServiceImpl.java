package com.hcid.partner.notification.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcid.partner.notification.dao.SmsQueueDAO;
import com.hcid.partner.notification.entity.SMSQueue;
import com.hcid.partner.notification.service.SmsQueueService;


import java.util.List;

/**
 * Created by andry.sunandar01 on 30/01/2018.
 */
@Service
public class SmsQueueServiceImpl implements SmsQueueService {

    @Autowired
    private SmsQueueDAO smsQueueDAO;

    public void saveOrUpdate (SMSQueue smsQueue){
    	smsQueueDAO.saveAndFlush(smsQueue);
    }
    
    public SMSQueue getByDescription (String description){
    	return smsQueueDAO.findByDescriptionOrderByCreatedDateDesc(description);
    }
}
