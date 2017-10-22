package property;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyService implements IPropertyService {

    public Properties getProperties(String path) {
        try {
            FileInputStream fileInputStream;
            Properties prop = new Properties();
            fileInputStream = new FileInputStream(path);
            prop.load(fileInputStream);
            return prop;
        } catch (IOException e) {
            System.out.println("Exception: file " + path + " not found");
        }
        return null;
    }


    public Integer getIntegerProperty(EnumProperty nameProperty, Properties properties) {
        Integer integerProperties = Integer.valueOf(properties.getProperty(String.valueOf(nameProperty)));
        return integerProperties;
    }

    public String getStringProperty(EnumProperty nameProperty, Properties properties) {
        String stringProperties = properties.getProperty(String.valueOf(nameProperty));
        return stringProperties;
    }

    public Boolean getBooleanProperty(EnumProperty nameProperty, Properties properties) {
        Boolean booleanProperies = Boolean.valueOf(properties.getProperty(String.valueOf(nameProperty)));
        return booleanProperies;
    }

}
