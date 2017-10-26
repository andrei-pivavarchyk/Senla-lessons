package com.configurator.entity;


import com.propertyService.PropertyService;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Configurator {




    public Object configure(Object object, PropertyService propertyService) throws IllegalAccessException {
        Class cl = object.getClass();
        Field[] fields = cl.getDeclaredFields();

        for (Field field : fields) {

            if (field.isAnnotationPresent(ConfigProperty.class)) {
                ConfigProperty annotation = field.getAnnotation(ConfigProperty.class);
                PropertyFileName propertyFileName = annotation.configName();
                PropertyName propertyName = annotation.propertyName();
                PropertyType propertyType = annotation.type();

                if (propertyType.equals(PropertyType.BOOLEAN)) {

                    Field configureField = getBooleanProperty(object, field, propertyName, propertyService);

                } else if (propertyType.equals(PropertyType.INTEGER)) {
                    Field configureField = getIntegerProperty(object, field, propertyName, propertyService);
                } else if (propertyType.equals(PropertyType.STRING)) {
                    Field configureField = getStringProperty(object, field, propertyName, propertyService);
                } else {
                    return null;
                }

            }
        }

        return object;

    }


    public List<Field> getAllFields(Field[] fields){
        List<Field> allFields=new ArrayList<Field>();
        Boolean getAllFields=false;

   while(getAllFields.equals(false)){


       for(Field field:fields){
           if(field.isAnnotationPresent(ConfigProperty.class)){fieldsWithAnnotations.add(field);}



       }

}

    }

    public Field getBooleanProperty(Object object, Field field, PropertyName propertyName, PropertyService propertyService) throws IllegalAccessException {

        Boolean booleanProperties = Boolean.valueOf(propertyService.getProperties(propertyName.toString()));
        field.setBoolean(object, booleanProperties);
        return field;
    }

    public Field getIntegerProperty(Object object, Field field, PropertyName propertyName, PropertyService propertyService) throws IllegalAccessException {
        Integer integerProperties = Integer.valueOf(propertyService.getProperties(propertyName.toString()));
        field.set(object, integerProperties);
        return field;
    }

    public Field getStringProperty(Object object, Field field, PropertyName propertyName, PropertyService propertyService) throws IllegalAccessException {
        String stringProperties = String.valueOf(propertyService.getProperties(propertyName.toString()));
        field.set(object, stringProperties);
        return field;
    }
}