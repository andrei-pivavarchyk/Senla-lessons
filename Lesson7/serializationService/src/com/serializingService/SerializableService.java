package com.serializingService;

import com.configurator.entity.ConfigProperty;
import com.configurator.entity.PropertyFilePath;
import com.configurator.entity.PropertyName;
import com.configurator.entity.PropertyType;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableService implements ISerializableService{

    @ConfigProperty(configPath = PropertyFilePath.CONFIG_HOTEL_PROPERTIES, propertyName = PropertyName.SERIALIZABLE_PATH_FILE, type = PropertyType.STRING)
    private String path;
    public void serializable(Object object) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(this.path))) {
            oos.writeObject(object);
        } catch (Exception e) {
        }
    }

    public Object deSerializable() {

        try (ObjectInputStream oin = new ObjectInputStream(new FileInputStream(this.path))) {
            Object object = (Object) oin.readObject();
            return object;

        } catch (Exception e) {
            return null;
        }
    }
}