package com.hotelInterface.autoConfiguration;


import property.EnumProperty;
import property.PropertyService;

import java.beans.PropertyEditorSupport;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

public class Configurator {

    private Properties properties;
    private Boolean propertyExist=false;

    public Object configure(Object object,Properties properties) throws IllegalAccessException {
        Class cl=object.getClass();
       Field[] fields = cl.getDeclaredFields();

       for(Field field:fields){

           if(field.isAnnotationPresent(ConfigProperty.class)){
               ConfigProperty annotation=field.getAnnotation(ConfigProperty.class);
             PropertyFileName propertyFileName=annotation.configName();
             PropertyName propertyName=annotation.propertyName();
             TypeAnnotation typeAnnotation=annotation.type();

             if(typeAnnotation.equals(TypeAnnotation.BOOLEAN)){

              Field configureField= getBooleanProperty(object,field,propertyName,properties);

             }
            else if(typeAnnotation.equals(TypeAnnotation.INTEGER)){
                 Field configureField= getIntegerProperty(object,field,propertyName,properties);
             }
            else if(typeAnnotation.equals(TypeAnnotation.STRING)){
                 Field configureField= getStringProperty(object,field,propertyName,properties);
             }
            else {
                return null;
            }

           }
       }

       return object;

    }

    public Field getBooleanProperty(Object object,Field field, PropertyName propertyName,Properties properties) throws IllegalAccessException {

            Boolean booleanProperties = Boolean.valueOf(properties.getProperty(String.valueOf(propertyName)));
            field.setBoolean(object,booleanProperties);
            return field;
    }

    public Field getIntegerProperty(Object object,Field field, PropertyName propertyName,Properties properties) throws IllegalAccessException {
        Integer integerProperties = Integer.valueOf(properties.getProperty(String.valueOf(propertyName)));
        field.set(object,integerProperties);
        return field;
    }

    public Field getStringProperty(Object object,Field field, PropertyName propertyName,Properties properties) throws IllegalAccessException {
        String stringProperties = String.valueOf(properties.getProperty(String.valueOf(propertyName)));
        field.set(object,stringProperties);
        return field;
    }



}
