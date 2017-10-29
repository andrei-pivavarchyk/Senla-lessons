package com.configurator.entity;

import com.propertyService.PropertyService;

import java.io.IOException;
import java.lang.reflect.Field;

public interface IConfigurator {
    Object configure(Object object, PropertyService propertyService) throws Exception;
    Field getBooleanProperty(Object object, Field field, PropertyService propertyService, String configPath,PropertyName propertyName)  throws Exception;
    Field getIntegerProperty(Object object, Field field, PropertyService propertyService, String configPath,PropertyName propertyName)throws Exception;
    Field getStringProperty(Object object, Field field, PropertyService propertyService, String configPath,PropertyName propertyName) throws Exception;
    }
