package net.homecredit.mss.ws.SendSmsMessageWS;

import java.util.Map;

public class SendSmsMessageWSProxy implements net.homecredit.mss.ws.SendSmsMessageWS.SendSmsMessageWS {
  private String _endpoint = null;
  private net.homecredit.mss.ws.SendSmsMessageWS.SendSmsMessageWS sendSmsMessageWS = null;
  
  public SendSmsMessageWSProxy() {
    _initSendSmsMessageWSProxy();
  }
  
  public SendSmsMessageWSProxy(String endpoint) {
    _endpoint = endpoint;
    _initSendSmsMessageWSProxy();
  }
  
  private void _initSendSmsMessageWSProxy() {
    try {
      sendSmsMessageWS = (new net.homecredit.mss.ws.SendSmsMessageWS.SendSmsMessageWSSoap11QSServiceLocator()).getSendSmsMessageWSSoap11QSPort();
      if (sendSmsMessageWS != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)sendSmsMessageWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)sendSmsMessageWS)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (sendSmsMessageWS != null)
      ((javax.xml.rpc.Stub)sendSmsMessageWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public net.homecredit.mss.ws.SendSmsMessageWS.SendSmsMessageWS getSendSmsMessageWS() {
    if (sendSmsMessageWS == null)
      _initSendSmsMessageWSProxy();
    return sendSmsMessageWS;
  }
  
  public net.homecredit.mss.ws.send_sms_message.SendSmsMessagesResponse sendSmsMessages(net.homecredit.mss.domain.types.SmsMessageType[] sendSmsMessagesRequest, Map<String, Object> param) throws java.rmi.RemoteException{
    if (sendSmsMessageWS == null)
      _initSendSmsMessageWSProxy();
    return sendSmsMessageWS.sendSmsMessages(sendSmsMessagesRequest, param);
  }
  
  
}