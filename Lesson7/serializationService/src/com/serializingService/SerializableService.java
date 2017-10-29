package com.serializingService;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableService implements ISerializableService{

    public void serializable(Object object,String path) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(object);
        } catch (Exception e) {
        }
    }

    public Object deSerializable(String path) {

        try (ObjectInputStream oin = new ObjectInputStream(new FileInputStream(path))) {
            Object object = (Object) oin.readObject();
            return object;

        } catch (Exception e) {
            return null;
        }
    }
}