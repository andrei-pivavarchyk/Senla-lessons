import Entity.Guest;
import Entity.Hotel;
import Entity.Room;
import Entity.Service;
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
        ArrayList<Room> newRooms= RoomService.readRoomsFromFile();
        for(Room r: newRooms){
            bestHotel.addRoom(r);
        }

        bestHotel.printAllRooms();
        bestHotel.printFreeRooms();
    }
}
