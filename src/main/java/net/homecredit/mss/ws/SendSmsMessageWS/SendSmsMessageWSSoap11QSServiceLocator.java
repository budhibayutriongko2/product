/**
 * SendSmsMessageWSSoap11QSServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.homecredit.mss.ws.SendSmsMessageWS;

public class SendSmsMessageWSSoap11QSServiceLocator extends org.apache.axis.client.Service implements net.homecredit.mss.ws.SendSmsMessageWS.SendSmsMessageWSSoap11QSService {

/**
 * OSB Service
 */

    public SendSmsMessageWSSoap11QSServiceLocator() {
    }


    public SendSmsMessageWSSoap11QSServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SendSmsMessageWSSoap11QSServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SendSmsMessageWSSoap11QSPort
    private java.lang.String SendSmsMessageWSSoap11QSPort_address = "https://osb.id00c1.id.infra:443/ID_PartnerPortal/SendSmsMessageService/v2/ID_PartnerPortalSendSmsMessageService_v2";

    public java.lang.String getSendSmsMessageWSSoap11QSPortAddress() {
        return SendSmsMessageWSSoap11QSPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SendSmsMessageWSSoap11QSPortWSDDServiceName = "SendSmsMessageWSSoap11QSPort";

    public java.lang.String getSendSmsMessageWSSoap11QSPortWSDDServiceName() {
        return SendSmsMessageWSSoap11QSPortWSDDServiceName;
    }

    public void setSendSmsMessageWSSoap11QSPortWSDDServiceName(java.lang.String name) {
        SendSmsMessageWSSoap11QSPortWSDDServiceName = name;
    }

    public net.homecredit.mss.ws.SendSmsMessageWS.SendSmsMessageWS getSendSmsMessageWSSoap11QSPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SendSmsMessageWSSoap11QSPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSendSmsMessageWSSoap11QSPort(endpoint);
    }

    public net.homecredit.mss.ws.SendSmsMessageWS.SendSmsMessageWS getSendSmsMessageWSSoap11QSPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            net.homecredit.mss.ws.SendSmsMessageWS.SendSmsMessageWSSoap11Stub _stub = new net.homecredit.mss.ws.SendSmsMessageWS.SendSmsMessageWSSoap11Stub(portAddress, this);
            _stub.setPortName(getSendSmsMessageWSSoap11QSPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSendSmsMessageWSSoap11QSPortEndpointAddress(java.lang.String address) {
        SendSmsMessageWSSoap11QSPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (net.homecredit.mss.ws.SendSmsMessageWS.SendSmsMessageWS.class.isAssignableFrom(serviceEndpointInterface)) {
                net.homecredit.mss.ws.SendSmsMessageWS.SendSmsMessageWSSoap11Stub _stub = new net.homecredit.mss.ws.SendSmsMessageWS.SendSmsMessageWSSoap11Stub(new java.net.URL(SendSmsMessageWSSoap11QSPort_address), this);
                _stub.setPortName(getSendSmsMessageWSSoap11QSPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("SendSmsMessageWSSoap11QSPort".equals(inputPortName)) {
            return getSendSmsMessageWSSoap11QSPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://homecredit.net/mss/ws/SendSmsMessageWS", "SendSmsMessageWSSoap11QSService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://homecredit.net/mss/ws/SendSmsMessageWS", "SendSmsMessageWSSoap11QSPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SendSmsMessageWSSoap11QSPort".equals(portName)) {
            setSendSmsMessageWSSoap11QSPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
