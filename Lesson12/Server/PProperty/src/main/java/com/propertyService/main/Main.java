package com.propertyService.main;


import com.propertyService.PPropertyService;
import com.propertyService.PPropertyService;

import java.util.Properties;

public class Main {

    public static void main(String[] args){


        PPropertyService propertyService=new PPropertyService();

        Properties properties=propertyService.getProperties("ds");
        System.out.print(properties.getProperty("com.testHotel.service.IPrinterService"));
    }

}