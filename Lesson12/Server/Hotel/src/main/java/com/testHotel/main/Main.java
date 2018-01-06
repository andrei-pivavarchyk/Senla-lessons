package com.testHotel.main;

import com.propertyService.PropertyService;

import java.util.List;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {

     //   HotelController hotelController = new HotelController();
     //   hotelController.startHotel();
      // NetServerThread.start();
       // PrinterService printerService=new PrinterService();
       // GuestDAO guestDAO=new GuestDAO();

       // printerService.printGuests(guestList);
        PropertyService propertyService=new PropertyService();

        Properties properties=propertyService.getProperties("ds");
        System.out.print(properties.getProperty("com.testHotel.service.IPrinterService"));
    }
}




