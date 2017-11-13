package com.testHotel.controller;


import com.testHotel.entity.Guest;
import com.testHotel.entity.Room;
import com.testHotel.entity.Service;
import com.testHotel.service.*;

import java.util.List;

public interface IHotelController {

    Room getRoomByNumber(Integer number);
    List<Room> getFreeRooms();
    void setFileService(IFileService fileService);
    void setPrinterService(IPrinterService printerService);
    void  setGuestService(IGuestService guestService);
    void  setRoomService(IRoomService roomService);
    void setServiceService(IServiceService serviceService);
    void addGuest(Integer roomNumber, Guest guest, Integer year, Integer month, Integer day);
    void addGuestService(Guest guest, Service service, Integer year, Integer month, Integer day);
    void readRoomsFromFile() throws Exception;
    void setRoomCost(int roomNumber, int cost, String path);
    void addService(Service service);
    IGuestService getGuestSerice();
    IRoomService getRoomService();
    IServiceService getServiceService();
    Room cloneRoom(Room room);
    void addRoom(Room room);
    void importRoom(String path)throws Exception;
    void exportRoom(String path)throws Exception;
    String getRoomFilePath();
    IPrinterService getPrinterService();
    List<Room> getAllRooms();
    List<Guest> getAllGuests();

}
