package com.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.serviceAPI.IObjectConverter;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class ObjectConverter implements IObjectConverter {
    public static Logger log = Logger.getLogger(ObjectConverter.class);
    private static ObjectMapper objectMapper = new ObjectMapper();

    public String convertObject(Object someObject) {
        try {
            String someString = objectMapper.writeValueAsString(someObject);
            return someString;
        } catch (IOException e) {
            log.error(e.toString());
            return e.toString();
        }
    }

    public Object convertJsonToObject(String str, Class clazz) {
        try {
            Object obj = objectMapper.readValue(str, clazz);
            return obj;
        } catch (IOException e) {
            log.error(e.toString());
        }
        return null;
    }
}
