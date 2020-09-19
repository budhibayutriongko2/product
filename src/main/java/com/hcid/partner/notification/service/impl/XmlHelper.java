package com.hcid.partner.notification.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * @param <T>
 * @author Dinda.Wahyudi06
 */
@Service
public class XmlHelper<T> {

    private static final Logger LOGGER = LogManager.getLogger(XmlHelper.class);

    public String getXmlString(T request) {
        String xmlString = "";
        try {
            JAXBContext jc = JAXBContext.newInstance(request.getClass());

            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter sw = new StringWriter();
            marshaller.marshal(request, sw);

            xmlString = sw.toString();
            LOGGER.debug(String.format("Marshalling success. With result: %s.", xmlString));
        } catch (JAXBException ex) {
            LOGGER.error(String.format("Marshalling failed. Caused by: %s.", ex.getMessage()));
        }
        return xmlString;
    }

    public T getObject(String xmlString, Class<T> clazz) {
        T result = null;
        if (!StringUtils.isBlank(xmlString)) {
        } else {
            return null;
        }
        try {
            JAXBContext jc = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = jc.createUnmarshaller();

            StringReader sr = new StringReader(xmlString);
            result = (T) unmarshaller.unmarshal(sr);

            LOGGER.debug(String.format("Unmarshalling success. With result: %s.", result.toString()));
        } catch (JAXBException ex) {
            LOGGER.error(String.format("Unmarshalling failed. Caused by: %s.", ex.getMessage()));
        }
        return result;
    }
}
