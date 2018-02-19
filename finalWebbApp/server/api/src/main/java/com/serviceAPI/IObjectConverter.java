package com.serviceAPI;

public interface IObjectConverter {
    String convertObject(Object someObject);
    Object convertJsonToObject(String str, Class clazz);
}
