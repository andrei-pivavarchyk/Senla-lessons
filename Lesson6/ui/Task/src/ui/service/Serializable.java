package ui.service;

import hotel.storage.GuestStorage;
import property.EnumProperty;
import property.Proops;
import ui.entity.Menu;

import java.io.*;

public class Serializable {

    public static void serializableMenu(Menu menu) {

        try {
            FileOutputStream fos = new FileOutputStream(Proops.getProperty(EnumProperty.SERIALIZABLE_PATH_FILE));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(menu);
            oos.flush();
            oos.close();
        } catch (IOException e) {

        }
    }

    public static Menu deSerializable() {

        try {
System.out.println(1);
            FileInputStream fis = new FileInputStream(Proops.getProperty(EnumProperty.SERIALIZABLE_PATH_FILE));
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
