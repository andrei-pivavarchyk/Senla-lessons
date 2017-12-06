package com.configurator;

import com.propertyService.IPropertyService;

import java.lang.reflect.Field;

public interface IConfigurator {
    Object configure(Object object);
    void setBooleanProperty(Object object, Field field, String configPath,PropertyName propertyName) throws Exception;
    void setIntegerProperty(Object object, Field field,  String configPath,PropertyName propertyName) throws Exception;
    void setStringProperty(Object object, Field field, String configPath,PropertyName propertyName) throws Exception;
    }
