package com.testHotel.main;
import com.dao.IRoomDAO;
import com.dao.RoomDAO;
import com.dao.TypeSorting;
import com.dependencyService.DependencyService;
import com.entity.Room;
import com.testHotel.controller.HotelController;
import com.testHotel.controller.IHotelController;

import java.util.List;

public class Main {
    public static void main(String[] args) {

     //   HotelController hotelController = new HotelController();
     //   hotelController.startHotel();
      // NetServerThread.start();
       // PrinterService printerService=new PrinterService();
       // GuestDAO guestDAO=new GuestDAO();

       // printerService.printGuests(guestList);
        IHotelController hotelControllerr=(IHotelController) DependencyService.getDI().getInstance(IHotelController.class);
        List<Room> roomList= hotelControllerr.getAllRooms();
        Integer roomCost=roomList.get(0).getCost();
        System.out.println(roomCost);


    }
}




