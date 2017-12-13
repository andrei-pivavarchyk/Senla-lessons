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
   void printFreeRoomsCount();
   List<Room> getFreeRoomsByDate(int year,int month,int day);
   List<GuestRoomInfo> getThreeLastGuests(int roomNumber);
   void setRoomCost(int roomNumber,int cost);
   List<Room> getArrayRoomCostSorting(ArrayList<Room> allRooms);
   List<Room> getArrayRoomCapacitySorting(ArrayList<Room> allRooms);
   List<Room> getArrayRoomStarsSorting(ArrayList<Room> allRooms);
   Room getRoomByNumber(int roomNumber);
   Room cloneRoom(Room room) throws CloneNotSupportedException;
   void glueTwoArrays(List<Room> importList );
}
