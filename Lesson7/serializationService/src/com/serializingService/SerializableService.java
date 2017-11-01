package com.serializingService;

import org.apache.log4j.Logger;

import java.io.*;

public class SerializableService {
    private static Logger log = Logger.getLogger(SerializableService.class);

    public void serializable(Object object, String path) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(object);
        } catch (FileNotFoundException e) {
            log.error(e.toString());
        } catch (IOException e) {
            log.error(e.toString());
        }
    }

    public Object deSerializable(String path) {
        try (ObjectInputStream oin = new ObjectInputStream(new FileInputStream(path))) {
            Object object = oin.readObject();
            return object;
        } catch (IOException e) {
            log.error(e.toString());
        } catch (ClassNotFoundException e) {
            log.error(e.toString());
        }
        return null;
    }
}