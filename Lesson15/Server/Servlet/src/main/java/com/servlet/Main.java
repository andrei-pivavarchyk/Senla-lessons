package com.servlet;


import com.dao.GuestDAO;
import com.dao.RoomDAO;
import com.entity.Room;
import com.testHotel.controller.HotelController;
import com.testHotel.service.GuestService;

public class Main {
    public static void main(String[] args) {
        HotelController hotelController=new HotelController();
        GuestService guestService=new GuestService();
        GuestDAO guestDAO=new GuestDAO();
        RoomDAO roomDAO=new RoomDAO();
        Room room=roomDAO.getEntityByNumber(77);
        System.out.print( room);
   }
}
