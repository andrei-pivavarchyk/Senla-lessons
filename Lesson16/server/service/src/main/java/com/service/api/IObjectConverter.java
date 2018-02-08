package com.service.api;

public interface IObjectConverter {
    String convertObject(Object someObject);
    Object convertJsonToObject(String str, Class clazz);
}
