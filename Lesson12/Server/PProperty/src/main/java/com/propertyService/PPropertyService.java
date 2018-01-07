package com.propertyService;

import com.propertyService.main.Main;
import org.apache.log4j.Logger;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class PPropertyService  {


    private Map<String, Properties> propsMap = new HashMap<>();
    private static volatile PPropertyService instance;
    private static Logger log = Logger.getLogger(PPropertyService.class);
    public static PPropertyService getPropertyService() {
        PPropertyService localInstance = instance;
        if (localInstance == null) {
            synchronized (PPropertyService.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new PPropertyService();
                }
            }
        }
        return localInstance;
    }









    public Properties getProperties(String propertyPath)  {
        File f=null;
        InputStream resource = Main.class.getClassLoader().getResourceAsStream("dependency.properties");

        if (propsMap.containsKey("dependency.properties")) {
            return propsMap.get(propertyPath);
        } else {
            try (InputStream inputStream = resource) {

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
