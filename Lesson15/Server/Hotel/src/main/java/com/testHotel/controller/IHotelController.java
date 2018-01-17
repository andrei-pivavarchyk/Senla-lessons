package com.testHotel.controller;


import com.dao.TypeSorting;
import com.entity.*;
import com.testHotel.service.*;

import java.sql.SQLException;
import java.util.List;

public interface IHotelController {
    void startHotel();

    void endHotel() throws SQLException;

    //Guest
    Long getAllGuestsCount();

    void addGuestToRoom(Integer roomNumber, Guest guest, Integer year, Integer month, Integer day);

    List<Guest> getAllGuests(TypeSorting sorting);

    Guest getGuestById(Integer id);

    Integer getPayAmount(Guest guest);

    List<GuestRoomInfo> getCurrentGuestRoomInfo();

    void addGuest(Guest guest);

    void removeGuest(Integer id);

    void updateGuest(Guest guest);

    //Room
    void addRoom(Room room);

    public void updateRoom(Room entity);

    public void deleteRoom(Integer id);

    List<Room> getAllRooms(TypeSorting sorting, RoomStatus status);

    Room getRoomById(Integer id);

    Room getRoomByNumber(Integer number);

    //Service
    public Service getServiceById(Integer id);

    public void addHotelService(Service service);

    public void updateService(Service service);

    public void deleteService(Integer id);

    List<Service> getAllHotelServices(TypeSorting sorting);

    //GuestService

    List<GuestServiceInfo> getAllGuestServicesInfo(Integer id, TypeSorting sorting);

    List<GuestServiceInfo> getGuestServiceByGuest(Integer id,TypeSorting sorting);

    void addGuestServiceInfo(GuestServiceInfo guestRoomInfo);

    void removeGuestServiceInfoByGuest(Integer id);

    void updateGuestServiceInfo(GuestServiceInfo guestServiceInfo);


    //


    void readRoomsFromFile() throws Exception;

    void setRoomCost(int roomNumber, int cost);

    IGuestService getGuestSerice();

    IRoomService getRoomService();

    IServiceService getServiceService();

    void importRoom(String path) throws Exception;

    void exportRoom(String path) throws Exception;

    String getRoomFilePath();

    IPrinterService getPrinterService();


}
