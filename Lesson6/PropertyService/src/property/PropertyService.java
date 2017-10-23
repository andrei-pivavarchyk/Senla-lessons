package property;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;

public class PropertyService implements IPropertyService, Serializable {

    public Properties readProperties(String path) {
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
        if (nameProperty.getType().equals("Integer")) {
            Integer integerProperties = Integer.valueOf(properties.getProperty(String.valueOf(nameProperty)));
            return integerProperties;
        } else {
            return null;
        }
    }

    public String getStringProperty(EnumProperty nameProperty, Properties properties) {
        if (nameProperty.getType().equals("String")) {
            String stringProperties = properties.getProperty(String.valueOf(nameProperty));
            return stringProperties;
        } else {
            return null;
        }
    }

    public Boolean getBooleanProperty(EnumProperty nameProperty, Properties properties) {
        if(nameProperty.getType().equals("Boolean")){
            Boolean booleanProperies = Boolean.valueOf(properties.getProperty(String.valueOf(nameProperty)));
            return booleanProperies;
        }
       else{
            return null;
        }
    }

}
