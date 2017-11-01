package com.configurator;

import com.propertyService.IPropertyService;

import java.lang.reflect.Field;

public interface IConfigurator {
    Object configure(Object object, IPropertyService propertyService) throws Exception;
    Field getBooleanProperty(Object object, Field field, IPropertyService propertyService, String configPath,PropertyName propertyName) throws Exception;
    Field getIntegerProperty(Object object, Field field, IPropertyService propertyService, String configPath,PropertyName propertyName) throws Exception;
    Field getStringProperty(Object object, Field field, IPropertyService propertyService, String configPath,PropertyName propertyName) throws Exception;
    }
