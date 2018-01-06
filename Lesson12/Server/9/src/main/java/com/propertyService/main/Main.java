package com.propertyService.main;


import com.propertyService.PropertyService;

import java.util.Properties;

public class Main {

    public static void main(String[] args){


        PropertyService propertyService=new PropertyService();

        Properties properties=propertyService.getProperties("ds");
        System.out.print(properties.getProperty("com.testHotel.service.IPrinterService"));
    }

}