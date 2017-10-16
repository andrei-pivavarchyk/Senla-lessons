package services;


import entity.Guest;
import entity.GuestRoomInfo;
import entity.Room;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface IRoomService {


   void addRoom(Room room);
   List<Room> getAllRooms();


   ArrayList<Room> getRoomCostSorting();
   ArrayList<Room>getRoomCapacitySorting();
   ArrayList<Room> getRoomStarsSorting();
   void addGuest(int roomNumber, Guest guest,int year,int month,int day);
   void departureGuest ( Guest guest);
    ArrayList<Room> getFreeRooms();
   void printFreeRoomsCount();
   ArrayList<Room> getFreeRoomsByDate(int year,int month,int day);
   ArrayList<GuestRoomInfo> getThreeLastGuests(int roomNumber);
   void setRoomCost(int roomNumber,int cost);
   ArrayList<Room> getArrayRoomCostSorting(ArrayList<Room> allRooms);
   ArrayList<Room> getArrayRoomCapacitySorting(ArrayList<Room> allRooms);
   ArrayList<Room> getArrayRoomStarsSorting(ArrayList<Room> allRooms);
   Room getRoomByNumber(int roomNumber);
}
