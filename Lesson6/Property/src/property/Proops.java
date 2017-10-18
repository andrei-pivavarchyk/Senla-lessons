package property;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Proops {

    //path to file
    public static String PATH_TO_PROPERTIES = "../resources/config.properties";

    public static String getProperty(EnumProperty nameProperty) {

        FileInputStream fileInputStream;
        Properties prop = new Properties();

        try {
            //get data
            fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
            prop.load(fileInputStream);
            String property = prop.getProperty(nameProperty.toString());

            return property;

        } catch (IOException e) {
            System.out.println("Exception: file " + PATH_TO_PROPERTIES + " not found");
            e.printStackTrace();
        }

        return null;
    }
}
