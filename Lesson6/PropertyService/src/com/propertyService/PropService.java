package com.propertyService;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropService implements IPropertyService {

    private Properties properties;

    public void setProperties(String path) throws IOException {

        try (InputStream inputStream = new FileInputStream(path)) {
            Properties prop = new Properties();
            prop.load(inputStream);
            this.properties = prop;
        }
    }

    public Boolean getChooseRoomStatus() {
        if (this.properties != null) {
            return Boolean.valueOf(this.properties.getProperty("CHOOSE_ROOM_STATUS"));
        } else {
            return null;
        }
    }

    public Integer getMaxNumberOfLastRoomGuests() {
        if (this.properties != null) {
            return Integer.valueOf(this.properties.getProperty("MAX_NUMBER_OF_LAST_ROOM_GUESTS"));
        } else {
            return null;
        }
    }

    public String getRoomPathFile() {
        if (this.properties != null) {
            return this.properties.getProperty("ROOM_PATH_FILE");
        } else {
            return null;
        }
    }

    public String getSerializablePathFile() {
        if (this.properties != null) {
            return this.properties.getProperty("SERIALIZABLE_PATH_FILE");
        } else {
            return null;
        }
    }

}
