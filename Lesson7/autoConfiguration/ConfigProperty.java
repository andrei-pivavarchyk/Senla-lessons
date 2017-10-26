package com.hotelInterface.autoConfiguration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value= ElementType.FIELD)
@Retention(value= RetentionPolicy.RUNTIME)
public @interface ConfigProperty {
    PropertyFileName configName();
    PropertyName propertyName();
    TypeAnnotation type();
}
