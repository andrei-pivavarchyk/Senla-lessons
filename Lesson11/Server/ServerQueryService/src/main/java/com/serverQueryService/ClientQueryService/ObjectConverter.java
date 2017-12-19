package com.serverQueryService.ClientQueryService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import java.io.IOException;
public class ObjectConverter {
    public static final Logger log = Logger.getLogger(ObjectConverter.class);
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String convertObject(Object someObject) {
        try {
            String someString = objectMapper.writeValueAsString(someObject);
            return someString;
        } catch (IOException e) {
            log.error(e.toString());
        }
        return null;
    }
}
