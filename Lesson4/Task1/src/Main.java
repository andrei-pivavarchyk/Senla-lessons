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
        Room r1= newRooms.get(2);
        for (Room r : newRooms) {
            hs.addRoom(r);
        }

        //1:
/*      hs.PrintFreeRoomsSortedBy(RoomSortType.Cost);
        hs.PrintFreeRoomsSortedBy(RoomSortType.Capacity);
        hs.PrintFreeRoomsSortedBy(RoomSortType.Stars);*/

        //2:
/*      hs.PrintRoomsSortedBy(RoomSortType.Cost);
        hs.PrintRoomsSortedBy(RoomSortType.Capacity);
        hs.PrintRoomsSortedBy(RoomSortType.Stars);*/

        //3:
        /*rs.PrintGuestsSortedBy(GuestInfoSortType.Name);*/

        //4
        /*System.out.println("Number of free rooms:" + hs.getFreeRoomsCount());*/

        //5
        /*System.out.println("Number of guests:" + hs.getGuestsCount());*/

        //6
        /*hs.printFreeRoomsByDate(new Date(2019,1,2));*/

        //7
        Guest g1 = new Guest("Jack","Daniels");
        Guest g2 = new Guest("Mack","Janiels");
        Guest g3 = new Guest("Back","Raniels");
        rs.checkInGuest(r1,g1,new Date(2017,1,2),new Date(2017,1,3));
        rs.checkInGuest(r1,g2,new Date(2017,1,2),new Date(2017,1,3));
        rs.checkInGuest(r1,g3,new Date(2017,1,2),new Date(2017,1,3));
        rs.getPaymentForGuest();

        //8 - move logic to hotel service
        rs.getLastThreeGuests();
    }
}