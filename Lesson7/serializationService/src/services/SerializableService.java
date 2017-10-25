package services;

import property.EnumProperty;
import property.PropertyService;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Properties;

public class SerializableService {
    private Properties properties;

    public SerializableService(Properties properties) {

        this.properties = properties;
    }

    public void serializable(Object object) {
        PropertyService propertyService = new PropertyService();
        String serializablePath = propertyService.getStringProperty(EnumProperty.SERIALIZABLE_PATH_FILE, this.properties);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(serializablePath))) {
            oos.writeObject(object);
        } catch (Exception e) {
        }
    }

    public Object deSerializable() {
        PropertyService propertyService = new PropertyService();
        String serializablePath = propertyService.getStringProperty(EnumProperty.SERIALIZABLE_PATH_FILE, this.properties);

        try (ObjectInputStream oin = new ObjectInputStream(new FileInputStream(serializablePath))) {
            Object object = (Object) oin.readObject();
            return object;

        } catch (Exception e) {
            return null;
        }
    }
}