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
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        Hotel bestHotel = new Hotel("bestHotel");
        HotelService hs = new HotelService(bestHotel);
        ArrayList<Room> newRooms = RoomService.readRoomsFromFile();
        for (Room r : newRooms) {
            hs.addRoom(r);
        }

        hs.PrintFreeRoomsSortedBy(RoomSortType.Capacity);
        hs.PrintFreeRoomsSortedBy(RoomSortType.Cost);
        hs.PrintFreeRoomsSortedBy(RoomSortType.Stars);
        System.out.println("Number of free rooms:" + hs.getFreeRoomsCount());
        System.out.println("Number of guests:" + hs.getGuestsCount());
    }
}