/**
 * SmsMessageType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.homecredit.mss.domain.types;


/**
 * Short message type.
 */
public class SmsMessageType  extends net.homecredit.mss.domain.types.AbstractMessageType  implements java.io.Serializable {
    private java.lang.String recipient;

    /* The text of the message. */
    private java.lang.String text;

    /* Expecting answer for this SMS. */
    private java.lang.Boolean isInteractive;

    /* Wait for answer for this interactive message till specified
     * time. Mandatory if isInteractive is set to true. */
    private java.util.Calendar answerTill;

    public SmsMessageType() {
    }

    public SmsMessageType(
           java.lang.String externalId,
           java.lang.String systemCode,
           java.lang.String messageCode,
           java.util.Calendar effectiveDate,
           java.util.Calendar expires,
           net.homecredit.mss.domain.types.BusinessAttributeTypeAttribute[] attributes,
           java.lang.String priority,
           java.lang.String reportLevel,
           net.homecredit.mss.domain.types.ReportContentType reportContentType,
           java.lang.String recipient,
           java.lang.String text,
           java.lang.Boolean isInteractive,
           java.util.Calendar answerTill) {
        super(
            externalId,
            systemCode,
            messageCode,
            effectiveDate,
            expires,
            attributes,
            priority,
            reportLevel,
            reportContentType);
        this.recipient = recipient;
        this.text = text;
        this.isInteractive = isInteractive;
        this.answerTill = answerTill;
    }


    /**
     * Gets the recipient value for this SmsMessageType.
     * 
     * @return recipient
     */
    public java.lang.String getRecipient() {
        return recipient;
    }


    /**
     * Sets the recipient value for this SmsMessageType.
     * 
     * @param recipient
     */
    public void setRecipient(java.lang.String recipient) {
        this.recipient = recipient;
    }


    /**
     * Gets the text value for this SmsMessageType.
     * 
     * @return text   * The text of the message.
     */
    public java.lang.String getText() {
        return text;
    }


    /**
     * Sets the text value for this SmsMessageType.
     * 
     * @param text   * The text of the message.
     */
    public void setText(java.lang.String text) {
        this.text = text;
    }


    /**
     * Gets the isInteractive value for this SmsMessageType.
     * 
     * @return isInteractive   * Expecting answer for this SMS.
     */
    public java.lang.Boolean getIsInteractive() {
        return isInteractive;
    }


    /**
     * Sets the isInteractive value for this SmsMessageType.
     * 
     * @param isInteractive   * Expecting answer for this SMS.
     */
    public void setIsInteractive(java.lang.Boolean isInteractive) {
        this.isInteractive = isInteractive;
    }


    /**
     * Gets the answerTill value for this SmsMessageType.
     * 
     * @return answerTill   * Wait for answer for this interactive message till specified
     * time. Mandatory if isInteractive is set to true.
     */
    public java.util.Calendar getAnswerTill() {
        return answerTill;
    }


    /**
     * Sets the answerTill value for this SmsMessageType.
     * 
     * @param answerTill   * Wait for answer for this interactive message till specified
     * time. Mandatory if isInteractive is set to true.
     */
    public void setAnswerTill(java.util.Calendar answerTill) {
        this.answerTill = answerTill;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SmsMessageType)) return false;
        SmsMessageType other = (SmsMessageType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.recipient==null && other.getRecipient()==null) || 
             (this.recipient!=null &&
              this.recipient.equals(other.getRecipient()))) &&
            ((this.text==null && other.getText()==null) || 
             (this.text!=null &&
              this.text.equals(other.getText()))) &&
            ((this.isInteractive==null && other.getIsInteractive()==null) || 
             (this.isInteractive!=null &&
              this.isInteractive.equals(other.getIsInteractive()))) &&
            ((this.answerTill==null && other.getAnswerTill()==null) || 
             (this.answerTill!=null &&
              this.answerTill.equals(other.getAnswerTill())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getRecipient() != null) {
            _hashCode += getRecipient().hashCode();
        }
        if (getText() != null) {
            _hashCode += getText().hashCode();
        }
        if (getIsInteractive() != null) {
            _hashCode += getIsInteractive().hashCode();
        }
        if (getAnswerTill() != null) {
            _hashCode += getAnswerTill().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SmsMessageType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://homecredit.net/mss/domain/types", "SmsMessageType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recipient");
        elemField.setXmlName(new javax.xml.namespace.QName("http://homecredit.net/mss/domain/types", "recipient"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://homecredit.net/mss/domain/types", "SmsRecipientType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("text");
        elemField.setXmlName(new javax.xml.namespace.QName("http://homecredit.net/mss/domain/types", "text"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isInteractive");
        elemField.setXmlName(new javax.xml.namespace.QName("http://homecredit.net/mss/domain/types", "isInteractive"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("answerTill");
        elemField.setXmlName(new javax.xml.namespace.QName("http://homecredit.net/mss/domain/types", "answerTill"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
