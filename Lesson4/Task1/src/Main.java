import Entity.*;
import Services.HotelService;
import Services.PrintIOperations;
import Services.RoomService;
import Sorting.GuestSorting;
import com.danco.training.TextFileWorker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        Hotel bestHotel = new Hotel("bestHotel");
        RoomService rs = new RoomService();
        HotelService hs = new HotelService(bestHotel, rs);
        ArrayList<Room> newRooms = RoomService.readRoomsFromFile();
        Room r1= newRooms.get(1);
        for (Room r : newRooms) {
            hs.addRoom(r);
        }

        hs.PrintFreeRoomsSortedBy(RoomSortType.Capacity);
        hs.PrintFreeRoomsSortedBy(RoomSortType.Cost);
        hs.PrintFreeRoomsSortedBy(RoomSortType.Stars);
        System.out.println("Number of free rooms:" + hs.getFreeRoomsCount());
        System.out.println("Number of guests:" + hs.getGuestsCount());
        Guest g = new Guest("Jack","Daniels");
        rs.checkInGuest(r1,g,new Date(2017,1,1));
        rs.getLastThreeGuests();
    }
}