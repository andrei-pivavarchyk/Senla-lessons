package com.serializingService;

import java.io.*;

public class SerializableService {

    public void serializable(Object object, String path) throws IOException {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(object);
        }
    }

    public Object deSerializable(String path) throws IOException, ClassNotFoundException {
        try (ObjectInputStream oin = new ObjectInputStream(new FileInputStream(path))) {
            Object object = oin.readObject();
            return object;
        }
    }
}