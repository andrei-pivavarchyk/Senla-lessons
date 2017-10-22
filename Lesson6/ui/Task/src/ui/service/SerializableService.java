package ui.service;

import property.EnumProperty;
import property.PropertyService;
import ui.entity.ProgramState;

import java.io.*;
import java.util.Properties;

public class SerializableService {
    private Properties properties;

    public SerializableService(Properties properties) {
        this.properties = properties;
    }

    public void serializable(ProgramState hotelStorages) {
        PropertyService propertyService = new PropertyService();
        try (OutputStream fos = new FileOutputStream(propertyService.getStringProperty(EnumProperty.SERIALIZABLE_PATH_FILE, this.properties))) {

            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(hotelStorages);
            oos.flush();
            oos.close();
        } catch (IOException e) {

        }
    }

    public ProgramState deSerializable() {
        PropertyService propertyService = new PropertyService();
        try (FileInputStream fis = new FileInputStream(propertyService.getStringProperty(EnumProperty.SERIALIZABLE_PATH_FILE, this.properties))) {
            ObjectInputStream oin = new ObjectInputStream(fis);
            ProgramState programState = (ProgramState) oin.readObject();
            return programState;

        } catch (IOException e) {
            return null;

        } catch (ClassNotFoundException e) {
            return null;
        }

    }
}
