package com.testHotel.main;


import com.testHotel.comparator.GuestServiceInfoDateComparator;
import com.testHotel.controller.HotelController;

import com.testHotel.dao.GuestDAO;
import com.testHotel.dao.GuestServiceDAO;
import com.testHotel.dao.RoomDAO;
import com.testHotel.dao.ServiceDAO;
import com.testHotel.entity.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        HotelController hotelController = new HotelController();
        hotelController.startHotel();

        // NetServerThread.start();

        GuestDAO guestDAO = new GuestDAO();
        RoomDAO roomDAO = new RoomDAO();
        Room room = new Room(44, 5550005, 3, 3);
Guest guest=new Guest(1,"bob","jjj");
Service service=new Service(8,ServiceType.EAT,"vodka",88);
        GuestServiceInfo guestServiceInfo=new GuestServiceInfo(8,guest,service,new Date());
      //  System.out.println(guestServiceInfo.getDate().getTime());

        ServiceDAO serviceDAO=new ServiceDAO();

 Timestamp timestamp=new Timestamp(new Date().getTime());

        GuestServiceDAO guestServiceDAO=new GuestServiceDAO();
        //guestServiceDAO.addEntity(guestServiceInfo);
        guestServiceDAO.removeEntity(guestServiceInfo);
       // hotelController.getPrinterService().printGuestServices(guestServiceDAO.getAllEntities());
      // guestDAO.addEntity(guest);

    }
}




