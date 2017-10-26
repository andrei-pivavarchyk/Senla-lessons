package com.configurator.entity.main;


import com.configurator.entity.Configurator;
import com.configurator.entity.Test1;
import com.configurator.entity.Test2;
import com.propertyService.PropertyService;

import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            PropertyService propertyService = new PropertyService("../resources/config.properties");

            Test1 test1=new Test1();
            Configurator configurator = new Configurator();
            configurator.configure(test1,propertyService);
            System.out.println(test1.getNumber());
            System.out.println(test1.getTest2().getNumber());
            System.out.println(test1.getTest2().getTest3().getNumber());
        }
        catch (IOException e){System.out.print(e);} catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {

        }





    }
}
