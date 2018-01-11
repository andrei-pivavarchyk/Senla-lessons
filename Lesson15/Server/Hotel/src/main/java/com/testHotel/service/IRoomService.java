package com.testHotel.service;

import com.entity.Guest;
import com.entity.Room;
import com.entity.RoomStatus;
import java.util.List;

public interface IRoomService {

   void addRoom(Room room);
   List<Room> getAllRooms();
   List<Room> getRoomCostSorting();
   List<Room>getRoomCapacitySorting();
   List<Room> getRoomStarsSorting();
   void addGuest(int roomNumber, Guest guest, int year, int month, int day);
   void departureGuest ( Guest guest);
    List<Room> getFreeRooms();
   Integer getFreeRoomsCount();
   void setRoomCost(int roomNumber,int cost);
   Room getRoomByNumber(int roomNumber);
   void importRooms(List<Room> importList);
   void setRoomStatus(Room room,RoomStatus roomStatus);
   Integer getMaxCountOldGuests();
}
