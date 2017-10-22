package ui.service;

import hotel.storage.GuestStorage;
import property.EnumProperty;
import property.PropertyService;
import ui.entity.Menu;

import java.io.*;
import java.util.Properties;

public class SerializableService {
    private Properties properties;

    public SerializableService(Properties properties) {
        this.properties = properties;
    }

    public void serializableMenu(Menu menu) {

        try {
            PropertyService propertyService = new PropertyService();
            FileOutputStream fos = new FileOutputStream(propertyService.getStringProperty(EnumProperty.SERIALIZABLE_PATH_FILE, this.properties));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(menu);
            oos.flush();
            oos.close();
        } catch (IOException e) {

        }
    }

    public Menu deSerializable() {

        try {
            System.out.println(1);
            PropertyService propertyService = new PropertyService();
            FileInputStream fis = new FileInputStream(propertyService.getStringProperty(EnumProperty.SERIALIZABLE_PATH_FILE, this.properties));
            System.out.println(2);
            ObjectInputStream oin = new ObjectInputStream(fis);
            System.out.println(3);
            Menu menu = (Menu) oin.readObject();
            return menu;
        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


}
