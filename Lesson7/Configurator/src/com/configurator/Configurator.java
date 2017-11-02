package com.configurator;

import com.dependencyService.DependencyService;
import com.propertyService.IPropertyService;
import com.sun.glass.ui.Accessible;
import com.testHotel.controller.IHotelController;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Configurator implements IConfigurator {
    private IPropertyService propertyService = (IPropertyService) DependencyService.getDI().getInstance(IPropertyService.class);
    private static Logger log = Logger.getLogger(Configurator.class);

    public Object configure(Object object) {

        Class cl = object.getClass();
        Field[] fields = cl.getDeclaredFields();
        List<Object> configureObjects = new ArrayList<Object>();

        try {
            for (Field field : fields) {
                Boolean accField = field.isAccessible();
                field.setAccessible(true);
                if (field.isAnnotationPresent(ConfigProperty.class)) {
                    ConfigProperty annotation = field.getAnnotation(ConfigProperty.class);
                    String propertyFilePath = annotation.configPath().getPath();
                    PropertyName propertyName = annotation.propertyName();

                    if (field.getType().equals(Boolean.class)) {
                       this.setBooleanProperty(object, field, propertyFilePath, propertyName);

                    } else if (field.getType().equals(Integer.class)) {
                        this.setIntegerProperty(object, field, propertyFilePath, propertyName);
                    } else if (field.getType().equals(String.class)) {
                        this.setStringProperty(object, field, propertyFilePath, propertyName);
                    } else {
                        return null;
                    }
                    field.setAccessible(accField);
                }

                if (field.isAnnotationPresent(Configurable.class)) {
                    configureObjects.add(field.get(object));
                }
            }

        } catch (IllegalAccessException e) {
            log.error(e.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Object object2 : configureObjects) {
            configure(object2);
        }
        return object;
    }

    public void setBooleanProperty(Object object, Field field, String configPath, PropertyName propertyName) throws Exception {
        Boolean booleanProperty = Boolean.valueOf(this.propertyService.getProperties(configPath).getProperty(propertyName.toString()));
        field.set(object, booleanProperty);
    }

    public void setIntegerProperty(Object object, Field field, String configPath, PropertyName propertyName) throws Exception {
        Integer integerProperty = Integer.valueOf(this.propertyService.getProperties(configPath).getProperty(propertyName.toString()));
        field.set(object, integerProperty);
    }

    public void setStringProperty(Object object, Field field, String configPath, PropertyName propertyName) throws Exception {
        String stringProperties = String.valueOf(this.propertyService.getProperties(configPath).getProperty(propertyName.toString()));
        field.set(object, stringProperties);
    }
}