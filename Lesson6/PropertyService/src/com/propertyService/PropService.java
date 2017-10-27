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
            return Boolean.valueOf(this.properties.getProperty(String.valueOf("CHOOSE_ROOM_STATUS")));
        } else {
            return null;
        }
    }

    public Integer getMaxNumberOfLastRoomGuests() {
        if (this.properties != null) {
            return Integer.valueOf(this.properties.getProperty(String.valueOf("MAX_NUMBER_OF_LAST_ROOM_GUESTS")));
        } else {
            return null;
        }
    }

    public String getRoomPathFile() {
        if (this.properties != null) {
            return this.properties.getProperty(String.valueOf("ROOM_PATH_FILE"));
        } else {
            return null;
        }
    }

    public String getSerializablePathFile() {
        if (this.properties != null) {
            return this.properties.getProperty(String.valueOf("SERIALIZABLE_PATH_FILE"));
        } else {
            return null;
        }
    }

    public String getExportPath() {
        if (this.properties != null) {
            return this.properties.getProperty(String.valueOf("EXPORT_PATH"));
        } else {
            return null;
        }
    }
}
