/**
 * SendSmsMessageWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.homecredit.mss.ws.SendSmsMessageWS;

import java.util.Map;

public interface SendSmsMessageWS extends java.rmi.Remote {
    public net.homecredit.mss.ws.send_sms_message.SendSmsMessagesResponse sendSmsMessages(net.homecredit.mss.domain.types.SmsMessageType[] sendSmsMessagesRequest, Map<String, Object> param) throws java.rmi.RemoteException;
}
