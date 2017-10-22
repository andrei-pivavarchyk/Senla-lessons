package ui;

import property.PropertyService;
import ui.controller.MenuController;
import ui.service.MainService;

import java.util.Properties;

public class Main {

    public static void main(String[] args) {

        PropertyService propertyService=new PropertyService();
        Properties properties=propertyService.getProperties("../resources/config.properties");

        MainService.getMainService().startHotel( "D:\\Rooms.txt");


        MenuController menuController=new MenuController();
        menuController.run();

    }

}
