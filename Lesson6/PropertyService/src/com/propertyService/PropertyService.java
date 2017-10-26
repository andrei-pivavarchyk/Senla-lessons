package com.propertyService;

import java.io.*;
import java.util.Properties;

public class PropertyService implements IPropertyService {


    private static Boolean CHOOSE_ROOM_STATUS;
    private static Integer MAX_NUMBER_OF_LAST_ROOM_GUESTS;
    private static String ROOM_PATH_FILE;
    private static String SERIALIZABLE_PATH_FILE;
    private static String EXPORT_PATH;


    public PropertyService(String path) throws IOException {
        try (InputStream inputStream = new FileInputStream(path)) {
            Properties prop = new Properties();
            prop.load(inputStream);

            this.CHOOSE_ROOM_STATUS = Boolean.valueOf(prop.getProperty(String.valueOf("CHOOSE_ROOM_STATUS")));
            this.MAX_NUMBER_OF_LAST_ROOM_GUESTS = Integer.valueOf(prop.getProperty(String.valueOf("MAX_NUMBER_OF_LAST_ROOM_GUESTS")));
            this.ROOM_PATH_FILE = prop.getProperty(String.valueOf("ROOM_PATH_FILE"));
            this.SERIALIZABLE_PATH_FILE = prop.getProperty(String.valueOf("SERIALIZABLE_PATH_FILE"));
            this.EXPORT_PATH = prop.getProperty(String.valueOf("EXPORT_PATH"));

        }

    }

    public  Boolean getChooseRoomStatus() {
        return CHOOSE_ROOM_STATUS;
    }

    public  Integer getMaxNumberOfLastRoomGuests() {
        return MAX_NUMBER_OF_LAST_ROOM_GUESTS;
    }

    public  String getRoomPathFile() {
        return ROOM_PATH_FILE;
    }

    public  String getSerializablePathFile() {
        return SERIALIZABLE_PATH_FILE;
    }

    public  String getExportPath() {
        return EXPORT_PATH;
    }
}
