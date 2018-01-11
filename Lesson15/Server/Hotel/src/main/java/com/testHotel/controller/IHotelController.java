package com.testHotel.controller;


import com.dao.TypeSorting;
import com.entity.Guest;
import com.entity.GuestRoomInfo;
import com.entity.Room;
import com.entity.Service;
import com.testHotel.service.*;

import java.sql.SQLException;
import java.util.List;

public interface IHotelController {
     void startHotel();
    void endHotel() throws SQLException;

    //GuestService
    Long  getAllGuestsCount();
    void addGuestToRoom(Integer roomNumber, Guest guest, Integer year, Integer month, Integer day);
    List<Guest> getAllGuests(TypeSorting sorting);
    Guest getGuestById(Integer id);
    Integer getPayAmount(Guest guest);
    List<GuestRoomInfo> getCurrentGuestRoomInfo();
    void addGuest(Guest guest);
    void removeGuest(Integer id);
    void updateGuest(Guest guest);




    Room getRoomByNumber(Integer number);
    List<Room> getFreeRooms();
    void setFileService(IFileService fileService);
    void setPrinterService(IPrinterService printerService);
    void  setGuestService(IGuestService guestService);
    void  setRoomService(IRoomService roomService);
    void setServiceService(IServiceService serviceService);
    void addGuestService(Guest guest, Service service, Integer year, Integer month, Integer day);
    void readRoomsFromFile() throws Exception;
    void setRoomCost(int roomNumber, int cost);
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
    List<Service> getAllServices();

}
