package com.propertyService;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyService implements IPropertyService {

    private Properties properties;
    private Map<String, Properties> propsMap = new HashMap<>();

    public Properties getProperties(String propertyPath) throws IOException {

        if (propsMap.containsKey(propertyPath)) {
            return propsMap.get(propertyPath);
        } else {
            try (InputStream inputStream = new FileInputStream(propertyPath)) {
                Properties prop = new Properties();
                prop.load(inputStream);
                propsMap.put(propertyPath, prop);
                return prop;
            }
        }
    }
}
