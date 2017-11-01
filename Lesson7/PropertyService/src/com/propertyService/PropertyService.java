package com.propertyService;

import org.apache.log4j.Logger;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyService implements IPropertyService {

    private Map<String, Properties> propsMap = new HashMap<>();
    private static Logger log = Logger.getLogger(PropertyService.class);

    public Properties getProperties(String propertyPath)  {
        if (propsMap.containsKey(propertyPath)) {
            return propsMap.get(propertyPath);
        } else {
            try (InputStream inputStream = new FileInputStream(propertyPath)) {
                Properties prop = new Properties();
                prop.load(inputStream);
                propsMap.put(propertyPath, prop);
                return prop;
            } catch (FileNotFoundException e) {
                log.error(e.toString());
            } catch (IOException e) {
                log.error(e.toString());
            }
            return null;
        }
    }
}
