package com.propertyService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public interface IPropertyService {
    void setProperties(String path) throws IOException;
    Boolean getChooseRoomStatus();
    Integer getMaxNumberOfLastRoomGuests();
    String getRoomPathFile();
    String getSerializablePathFile();
    String getExportPath();

}
