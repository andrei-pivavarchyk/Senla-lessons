package com.configurator.entity.main;


import com.configurator.entity.Configurator;
import com.configurator.entity.Test1;
import com.configurator.entity.Test2;
import com.configurator.entity.Test3;
import com.propertyService.PropertyService;

import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            PropertyService propertyService = new PropertyService("../resources/config.properties");

            Test1 test1=new Test1();
            Test2 test2=new Test2();
            Test3 test3=new Test3();

            test1.setNumber(666);
            test2.setNumber(666);
            test3.setNumber(666);

            test1.setTest2(test2);
            test2.setTest3(test3);

            Configurator configurator = new Configurator();
            configurator.configure(test1,propertyService);
            System.out.println(test1.getNumber());
            System.out.println(test2.getNumber());
            System.out.println(test3.getNumber());
        }
        catch (IOException e){System.out.print(e);} catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {

        }





    }
}
