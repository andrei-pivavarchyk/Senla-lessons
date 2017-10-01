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


   ArrayList<Room> getRoomCostSorting(List<Room> roomList);
   ArrayList<Room>getRoomCapacitySorting(List<Room> roomList);
   ArrayList<Room> getRoomStarsSorting(List<Room> roomList);
   void addGuest(int roomNumber, Guest guest,int year,int month,int day);
   void departureGuest ( Guest guest);
    ArrayList<Room> getFreeRooms();
   void printFreeRoomsCount();
   ArrayList<Room> getFreeRoomsByDate(int year,int month,int day);
   ArrayList<GuestRoomInfo> getThreeLastGuests(int roomNumber);

}
