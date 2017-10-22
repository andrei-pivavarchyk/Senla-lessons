package property;

import java.util.Properties;

public interface IPropertyService {
    Properties getProperties(String path);
    Integer getIntegerProperty(EnumProperty nameProperty, Properties properties);
    Boolean getBooleanProperty(EnumProperty nameProperty, Properties properties);
    String getStringProperty(EnumProperty nameProperty, Properties properties);
}