package com.testHotel.main;


import com.dao.GuestDAO;
import com.dao.TypeSorting;
import com.entity.Guest;
import com.testHotel.controller.HotelController;
import com.testHotel.service.PrinterService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        HotelController hotelController = new HotelController();
        hotelController.startHotel();

      // NetServerThread.start();
        PrinterService printerService=new PrinterService();
        GuestDAO guestDAO=new GuestDAO();
      List<Guest> guestList= guestDAO.getAllEntities(TypeSorting.NO_SORTING);
      System.out.println(guestList.get(0));
       // printerService.printGuests(guestList);

    }
}




