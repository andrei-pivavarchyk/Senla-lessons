package com.testHotel.service;


import com.testHotel.entity.Guest;
import com.testHotel.entity.GuestRoomInfo;
import com.testHotel.entity.Room;

import java.util.ArrayList;
import java.util.List;

public interface IRoomService {


   void addRoom(Room room);
   List<Room> getAllRooms();


   List<Room> getRoomCostSorting();
   List<Room>getRoomCapacitySorting();
   List<Room> getRoomStarsSorting();
   void addGuest(int roomNumber, Guest guest,int year,int month,int day);
   void departureGuest ( Guest guest);
    List<Room> getFreeRooms();
   Integer getFreeRoomsCount();
   List<Room> getFreeRoomsByDate(int year,int month,int day);
   List<GuestRoomInfo> getThreeLastGuests(int roomNumber);
   void setRoomCost(int roomNumber,int cost);
   Room getRoomByNumber(int roomNumber);
   void importRooms(List<Room> importList);
}
