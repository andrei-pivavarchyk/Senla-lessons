package com.dependencyService;


import com.configurator.PropertyFilePath;
import com.propertyService.PropertyService;
import org.apache.log4j.Logger;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class DependencyService {

    private Map<Class, Object> listObjects = new HashMap<>();
    private String propertyFilePath = PropertyFilePath.CONFIG_DEPENDENCY.getPath();
    private PropertyService propertyService = PropertyService.getPropertyService();
    private static Logger log = Logger.getLogger(DependencyService.class);
    private static volatile DependencyService instance;

    public static DependencyService getDI() {
        DependencyService localInstance = instance;
        if (localInstance == null) {
            synchronized (DependencyService.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DependencyService();
                }
            }
        }
        return localInstance;
    }

    public Object getInstance(Class classObject) {

        if (this.listObjects.get(classObject) != null) {
            return this.listObjects.get(classObject);
        } else {
            try {
                Properties properties = this.propertyService.getProperties(this.propertyFilePath);
                String currentProperty = properties.getProperty(classObject.getName());
                Class someClass = Class.forName(currentProperty);
                Object someObject = someClass.newInstance();
                this.listObjects.put(classObject, someObject);
                return someObject;
            } catch (Exception e) {
                log.error(e.toString());
            }
        }
        return null;
    }
}
