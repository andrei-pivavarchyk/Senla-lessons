package Domain.Services;

import Domain.Entities.Guest;
import Domain.Entities.Room;
import Sorting.GuestInfoSortType;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public interface IRoomService {
    static ArrayList<Room> readRoomsFromFile() {
        try {
            File f = new File("J:\\Rooms.txt");
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine = "";
            System.out.println("Reading file using Buffered Reader");

            ArrayList<Room> rooms = new ArrayList<>();
            while ((readLine = b.readLine()) != null) {
                String[] str = readLine.split("\\|");
                int number = Integer.parseInt(str[0]);
                int cost = Integer.parseInt(str[1]);
                int capacity = Integer.parseInt(str[2]);
                int stars = Integer.parseInt(str[3]);
                Room room = new Room(number, cost, capacity, stars, 2);
                rooms.add(room);
            }

            return rooms;
        } catch (IOException ex) {
            return null;
        }
    }

    void checkInGuest(Room room, Guest guest, Date arrivalDate, Date departureDate);

    void checkOutGuest(Room room, Guest guest);

    void PrintGuestsSortedBy(GuestInfoSortType guestsSortType);

    ArrayList<Room> getRoomsCountFreedByDate(Date date);

    void getPaymentForGuest();

    ArrayList<Guest> getLastThreeGuests();
}
