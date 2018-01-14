package com.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.io.IOException;

public class ObjectConverterToJson {
    public static final Logger log = Logger.getLogger(ObjectConverterToJson.class);
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static synchronized String convertObject(Object someObject) {
        try {

            String someString = objectMapper.writeValueAsString(someObject);
            return someString;
        } catch (IOException e) {
            log.error(e.toString());
            return e.toString();
        }
    }
}
