package com.propertyService;

import java.io.FileNotFoundException;
import java.util.Properties;

public interface IPropertyService {
    Boolean getChooseRoomStatus();
    Integer getMaxNumberOfLastRoomGuests();
    String getRoomPathFile();
    String getSerializablePathFile();
    String getExportPath();
}
