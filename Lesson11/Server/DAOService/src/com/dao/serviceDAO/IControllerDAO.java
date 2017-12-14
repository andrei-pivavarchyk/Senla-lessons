package com.dao.serviceDAO;

import com.testHotel.entity.*;

import java.util.List;

public interface IControllerDAO {
     List<Guest> getAllGuests();
    List<Guest> getAllGuestsSortedByDateDeparture();
    Integer getAllGuestsCount();
    Integer getPayAmount(Guest guest);
    List<GuestRoomInfo> getCurrentGuestRoomInfo();
    List<Guest> getAllGuestsSortedByName();
    void addRoom(Room room);
    List<Room> getAllRooms();
    List<Room> getRoomCostSorting();
    List<Room> getRoomCapacitySorting();
    List<Room> getRoomStarsSorting();
    Room getRoomByNumber(int roomNumber);
    void addGuest(int roomNumber, Guest guest, int year, int month, int day);
    int getCountOldRoomGuests(Room room);
    void departureGuest(Guest guest);
    List<Room> getFreeRooms();
    List<Room> getFreeRoomsCount();
    List<Room> getFreeRoomsByDate(int year, int month, int day);
    List<GuestRoomInfo> getThreeLastGuests(int roomNumber);
    void setRoomCost(int roomNumber, int cost);
    void importRooms(List<Room> importList);
    void addGuestService(Guest guest, Service service, int year, int month, int day);
    List<GuestServiceInfo> getAllGuestServicesInfo(Guest guest);
    void addService(Service service);
    List<Service> getAllHotelServices();
    List<Service> getAllHotelServicesSortedByCost();
    List<GuestServiceInfo> getAllGuestServicesInfoSortedByCost(Guest guest);
    List<GuestServiceInfo> getAllGuestServicesInfoSortedByDate(Guest guest);
}
