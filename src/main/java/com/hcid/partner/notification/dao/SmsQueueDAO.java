package com.hcid.partner.notification.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hcid.partner.notification.entity.SMSQueue;

/**
 * Created by andry.sunandar01 on 30/01/2018.
 */
@Repository
@Transactional
public interface SmsQueueDAO extends JpaRepository<SMSQueue,String>{
	SMSQueue findByDescriptionOrderByCreatedDateDesc(String description);
}
