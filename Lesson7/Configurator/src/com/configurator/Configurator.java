package com.configurator;

import com.propertyService.IPropertyService;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Configurator implements IConfigurator {

    private static Logger log = Logger.getLogger(Configurator.class);

    public Object configure(Object object, IPropertyService propertyService) {

        Class cl = object.getClass();
        Field[] fields = cl.getDeclaredFields();
        List<Object> configureObjects = new ArrayList<Object>();

        try {
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(ConfigProperty.class)) {
                    ConfigProperty annotation = field.getAnnotation(ConfigProperty.class);
                    String propertyFilePath = annotation.configPath().getPath();
                    PropertyName propertyName = annotation.propertyName();
                    PropertyType propertyType = annotation.type();

                    if (propertyType.equals(PropertyType.BOOLEAN)) {

                        Field configureField = getBooleanProperty(object, field, propertyService, propertyFilePath, propertyName);

                    } else if (propertyType.equals(PropertyType.INTEGER)) {
                        Field configureField = getIntegerProperty(object, field, propertyService, propertyFilePath, propertyName);
                    } else if (propertyType.equals(PropertyType.STRING)) {
                        Field configureField = getStringProperty(object, field, propertyService, propertyFilePath, propertyName);
                    } else {
                        return null;
                    }
                }

                if (field.isAnnotationPresent(Configurable.class)) {
                    configureObjects.add(field.get(object));
                }
            }

        } catch (IllegalAccessException e) {
            log.error(e.toString());
        } catch (Exception e) {
            log.error(e.toString());
        }

        for (Object object2 : configureObjects) {
            configure(object2, propertyService);
        }
        return object;
    }

    public Field getBooleanProperty(Object object, Field field, IPropertyService propertyService, String configPath, PropertyName propertyName) throws Exception {

        Boolean booleanProperty = Boolean.valueOf(propertyService.getProperties(configPath).getProperty(propertyName.toString()));
        field.set(object, booleanProperty);
        field.setAccessible(false);
        return field;
    }

    public Field getIntegerProperty(Object object, Field field, IPropertyService propertyService, String configPath, PropertyName propertyName) throws Exception {
        Integer integerProperty = Integer.valueOf(propertyService.getProperties(configPath).getProperty(propertyName.toString()));
        field.set(object, integerProperty);
        field.setAccessible(false);
        return field;
    }

    public Field getStringProperty(Object object, Field field, IPropertyService propertyService, String configPath, PropertyName propertyName) throws Exception {
        String stringProperties = String.valueOf(propertyService.getProperties(configPath).getProperty(propertyName.toString()));
        field.set(object, stringProperties);
        field.setAccessible(false);
        return field;
    }
}