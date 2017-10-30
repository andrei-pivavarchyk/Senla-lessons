package com.testHotel.controller;


import com.testHotel.entity.Guest;
import com.testHotel.entity.Room;
import com.testHotel.entity.Service;
import com.testHotel.service.*;

public interface IHotelController {
    void setFileService(IFileService fileService);
    void setPrinterService(IPrinterService printerService);
    void  setGuestService(IGuestService guestService);
    void  setRoomService(IRoomService roomService);
    void setServiceService(IServiceService serviceService);
    void addGuest(int roomNumber, Guest guest, int year, int month, int day);
    void addGuestService(Guest guest, Service service, int year, int month, int day);
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

}
