/**
 * AbstractMessageType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.homecredit.mss.domain.types;


/**
 * Abstract message type. Contains common elements for all types of
 * messages.
 */
public class AbstractMessageType  implements java.io.Serializable {
    /* Unique identification of message. MUST be provided by external
     * system. MAY be deduped. */
    private java.lang.String externalId;

    /* Unique identification of external system. MAY be validated. */
    private java.lang.String systemCode;

    /* This represents the category of the message. MANDATORY. */
    private java.lang.String messageCode;

    /* The effective date this message will be sent. If empty, then
     * NOW is used. */
    private java.util.Calendar effectiveDate;

    /* Message expiry time. Time at which a message loses its validity.
     * Send EXPIRED status if not send before this time.
     *                         Mandatory for interactive messages. */
    private java.util.Calendar expires;

    /* Business attributes, like CUID or Contract code. */
    private net.homecredit.mss.domain.types.BusinessAttributeTypeAttribute[] attributes;

    /* Priority of the message. */
    private java.lang.String priority;

    /* An enumeration of report level values. */
    private java.lang.String reportLevel;

    /* Requested status/delivery report format (JSON or XML). Default
     * is JSON. */
    private net.homecredit.mss.domain.types.ReportContentType reportContentType;

    public AbstractMessageType() {
    }

    public AbstractMessageType(
           java.lang.String externalId,
           java.lang.String systemCode,
           java.lang.String messageCode,
           java.util.Calendar effectiveDate,
           java.util.Calendar expires,
           net.homecredit.mss.domain.types.BusinessAttributeTypeAttribute[] attributes,
           java.lang.String priority,
           java.lang.String reportLevel,
           net.homecredit.mss.domain.types.ReportContentType reportContentType) {
           this.externalId = externalId;
           this.systemCode = systemCode;
           this.messageCode = messageCode;
           this.effectiveDate = effectiveDate;
           this.expires = expires;
           this.attributes = attributes;
           this.priority = priority;
           this.reportLevel = reportLevel;
           this.reportContentType = reportContentType;
    }


    /**
     * Gets the externalId value for this AbstractMessageType.
     * 
     * @return externalId   * Unique identification of message. MUST be provided by external
     * system. MAY be deduped.
     */
    public java.lang.String getExternalId() {
        return externalId;
    }


    /**
     * Sets the externalId value for this AbstractMessageType.
     * 
     * @param externalId   * Unique identification of message. MUST be provided by external
     * system. MAY be deduped.
     */
    public void setExternalId(java.lang.String externalId) {
        this.externalId = externalId;
    }


    /**
     * Gets the systemCode value for this AbstractMessageType.
     * 
     * @return systemCode   * Unique identification of external system. MAY be validated.
     */
    public java.lang.String getSystemCode() {
        return systemCode;
    }


    /**
     * Sets the systemCode value for this AbstractMessageType.
     * 
     * @param systemCode   * Unique identification of external system. MAY be validated.
     */
    public void setSystemCode(java.lang.String systemCode) {
        this.systemCode = systemCode;
    }


    /**
     * Gets the messageCode value for this AbstractMessageType.
     * 
     * @return messageCode   * This represents the category of the message. MANDATORY.
     */
    public java.lang.String getMessageCode() {
        return messageCode;
    }


    /**
     * Sets the messageCode value for this AbstractMessageType.
     * 
     * @param messageCode   * This represents the category of the message. MANDATORY.
     */
    public void setMessageCode(java.lang.String messageCode) {
        this.messageCode = messageCode;
    }


    /**
     * Gets the effectiveDate value for this AbstractMessageType.
     * 
     * @return effectiveDate   * The effective date this message will be sent. If empty, then
     * NOW is used.
     */
    public java.util.Calendar getEffectiveDate() {
        return effectiveDate;
    }


    /**
     * Sets the effectiveDate value for this AbstractMessageType.
     * 
     * @param effectiveDate   * The effective date this message will be sent. If empty, then
     * NOW is used.
     */
    public void setEffectiveDate(java.util.Calendar effectiveDate) {
        this.effectiveDate = effectiveDate;
    }


    /**
     * Gets the expires value for this AbstractMessageType.
     * 
     * @return expires   * Message expiry time. Time at which a message loses its validity.
     * Send EXPIRED status if not send before this time.
     *                         Mandatory for interactive messages.
     */
    public java.util.Calendar getExpires() {
        return expires;
    }


    /**
     * Sets the expires value for this AbstractMessageType.
     * 
     * @param expires   * Message expiry time. Time at which a message loses its validity.
     * Send EXPIRED status if not send before this time.
     *                         Mandatory for interactive messages.
     */
    public void setExpires(java.util.Calendar expires) {
        this.expires = expires;
    }


    /**
     * Gets the attributes value for this AbstractMessageType.
     * 
     * @return attributes   * Business attributes, like CUID or Contract code.
     */
    public net.homecredit.mss.domain.types.BusinessAttributeTypeAttribute[] getAttributes() {
        return attributes;
    }


    /**
     * Sets the attributes value for this AbstractMessageType.
     * 
     * @param attributes   * Business attributes, like CUID or Contract code.
     */
    public void setAttributes(net.homecredit.mss.domain.types.BusinessAttributeTypeAttribute[] attributes) {
        this.attributes = attributes;
    }


    /**
     * Gets the priority value for this AbstractMessageType.
     * 
     * @return priority   * Priority of the message.
     */
    public java.lang.String getPriority() {
        return priority;
    }


    /**
     * Sets the priority value for this AbstractMessageType.
     * 
     * @param priority   * Priority of the message.
     */
    public void setPriority(java.lang.String priority) {
        this.priority = priority;
    }


    /**
     * Gets the reportLevel value for this AbstractMessageType.
     * 
     * @return reportLevel   * An enumeration of report level values.
     */
    public java.lang.String getReportLevel() {
        return reportLevel;
    }


    /**
     * Sets the reportLevel value for this AbstractMessageType.
     * 
     * @param reportLevel   * An enumeration of report level values.
     */
    public void setReportLevel(java.lang.String reportLevel) {
        this.reportLevel = reportLevel;
    }


    /**
     * Gets the reportContentType value for this AbstractMessageType.
     * 
     * @return reportContentType   * Requested status/delivery report format (JSON or XML). Default
     * is JSON.
     */
    public net.homecredit.mss.domain.types.ReportContentType getReportContentType() {
        return reportContentType;
    }


    /**
     * Sets the reportContentType value for this AbstractMessageType.
     * 
     * @param reportContentType   * Requested status/delivery report format (JSON or XML). Default
     * is JSON.
     */
    public void setReportContentType(net.homecredit.mss.domain.types.ReportContentType reportContentType) {
        this.reportContentType = reportContentType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AbstractMessageType)) return false;
        AbstractMessageType other = (AbstractMessageType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.externalId==null && other.getExternalId()==null) || 
             (this.externalId!=null &&
              this.externalId.equals(other.getExternalId()))) &&
            ((this.systemCode==null && other.getSystemCode()==null) || 
             (this.systemCode!=null &&
              this.systemCode.equals(other.getSystemCode()))) &&
            ((this.messageCode==null && other.getMessageCode()==null) || 
             (this.messageCode!=null &&
              this.messageCode.equals(other.getMessageCode()))) &&
            ((this.effectiveDate==null && other.getEffectiveDate()==null) || 
             (this.effectiveDate!=null &&
              this.effectiveDate.equals(other.getEffectiveDate()))) &&
            ((this.expires==null && other.getExpires()==null) || 
             (this.expires!=null &&
              this.expires.equals(other.getExpires()))) &&
            ((this.attributes==null && other.getAttributes()==null) || 
             (this.attributes!=null &&
              java.util.Arrays.equals(this.attributes, other.getAttributes()))) &&
            ((this.priority==null && other.getPriority()==null) || 
             (this.priority!=null &&
              this.priority.equals(other.getPriority()))) &&
            ((this.reportLevel==null && other.getReportLevel()==null) || 
             (this.reportLevel!=null &&
              this.reportLevel.equals(other.getReportLevel()))) &&
            ((this.reportContentType==null && other.getReportContentType()==null) || 
             (this.reportContentType!=null &&
              this.reportContentType.equals(other.getReportContentType())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getExternalId() != null) {
            _hashCode += getExternalId().hashCode();
        }
        if (getSystemCode() != null) {
            _hashCode += getSystemCode().hashCode();
        }
        if (getMessageCode() != null) {
            _hashCode += getMessageCode().hashCode();
        }
        if (getEffectiveDate() != null) {
            _hashCode += getEffectiveDate().hashCode();
        }
        if (getExpires() != null) {
            _hashCode += getExpires().hashCode();
        }
        if (getAttributes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAttributes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAttributes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPriority() != null) {
            _hashCode += getPriority().hashCode();
        }
        if (getReportLevel() != null) {
            _hashCode += getReportLevel().hashCode();
        }
        if (getReportContentType() != null) {
            _hashCode += getReportContentType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AbstractMessageType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://homecredit.net/mss/domain/types", "AbstractMessageType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("externalId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://homecredit.net/mss/domain/types", "externalId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("systemCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://homecredit.net/mss/domain/types", "systemCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("messageCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://homecredit.net/mss/domain/types", "messageCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("effectiveDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://homecredit.net/mss/domain/types", "effectiveDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("expires");
        elemField.setXmlName(new javax.xml.namespace.QName("http://homecredit.net/mss/domain/types", "expires"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("attributes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://homecredit.net/mss/domain/types", "attributes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://homecredit.net/mss/domain/types", ">BusinessAttributeType>attribute"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://homecredit.net/mss/domain/types", "attribute"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("priority");
        elemField.setXmlName(new javax.xml.namespace.QName("http://homecredit.net/mss/domain/types", "priority"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://homecredit.net/mss/domain/types", "PriorityType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reportLevel");
        elemField.setXmlName(new javax.xml.namespace.QName("http://homecredit.net/mss/domain/types", "reportLevel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://homecredit.net/mss/domain/types", "ReportLevel"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reportContentType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://homecredit.net/mss/domain/types", "reportContentType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://homecredit.net/mss/domain/types", "ReportContentType"));
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
