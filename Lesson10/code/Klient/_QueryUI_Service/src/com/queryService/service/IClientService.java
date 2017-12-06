package com.queryService.service;

import com.entity.Guest;
import com.entity.GuestServiceInfo;
import com.entity.Room;
import com.entity.Service;

import java.util.List;

public interface IClientService {
    void startSocket();
    void closeSocket();
    void addGuest(Integer roomNumber, Guest guest, Integer year, Integer month, Integer day);
    List<Room> getAllRooms();
    List<Guest> getAllGuests();
    List<Room> getFreeRooms();
    Room getRoomByNumber(Integer roomNumber);
    void addRoom(Room room);
    Room clonerRoom(Room room);
    void exportRoom(String path);
    void importRoom(String path);
    List<Room> getRoomCapacitySorting();
    List<Room> getRoomCostSorting();
    List<Room> getRoomStarsSorting();
    List<Room> getArrayRoomCapacitySorting(List<Room> roomList);
    List<Room> getArrayRoomCostSorting(List<Room> roomList);
    List<Room> getArrayRoomStarsSorting(List<Room> roomList);
    List<Service> getAllHotelServices();
    void addHotelService(Service someService);
    List<GuestServiceInfo> getAllGuestServicesInfo(Guest guest);
}
