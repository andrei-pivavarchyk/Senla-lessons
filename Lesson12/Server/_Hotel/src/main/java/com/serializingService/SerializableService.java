package com.serializingService;

import com.configurator.ConfigProperty;
import com.configurator.PropertyFilePath;
import com.configurator.PropertyName;
import org.apache.log4j.Logger;

import java.io.*;

public class SerializableService implements ISerializableService {
    @ConfigProperty(configPath = PropertyFilePath.CONFIG_HOTEL_PROPERTIES, propertyName = PropertyName.SERIALIZABLE_PATH_FILE)
    private String serializationPath;
    private static Logger log = Logger.getLogger(SerializableService.class);

    public void serializable(Object object) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(this.serializationPath))) {
            oos.writeObject(object);
        } catch (FileNotFoundException e) {
            log.error(e.toString());
        } catch (IOException e) {
            log.error(e.toString());
        }
    }

    public Object deSerializable() {
        try (ObjectInputStream oin = new ObjectInputStream(new FileInputStream(this.serializationPath))) {
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

