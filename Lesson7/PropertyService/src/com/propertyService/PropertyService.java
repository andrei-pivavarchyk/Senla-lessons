package com.propertyService;

import java.io.*;
import java.util.Properties;

public class PropertyService implements IPropertyService {

    private Properties properties;


    public PropertyService(String path) throws IOException {
        try (InputStream inputStream = new FileInputStream(path)) {
            Properties prop = new Properties();
            prop.load(inputStream);

            this.properties = prop;

        }

    }

    public String getProperties(String propertyName) {

        String properties = this.properties.getProperty(propertyName);
        return properties;

    }
}
