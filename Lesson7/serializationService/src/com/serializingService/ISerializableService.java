package com.serializingService;


public interface ISerializableService {
    void serializable(Object object,String path);
    Object deSerializable(String path);
}
