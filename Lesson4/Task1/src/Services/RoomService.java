package Services;

import Comparator.GuestInfoNameComporator;
import Entity.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class RoomService {
    private ArrayList<GuestInfo> guestsInfo = new ArrayList<>();

    public static ArrayList<Room> readRoomsFromFile() {
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
                Room room = new Room(number, cost, capacity, stars);
                rooms.add(room);
            }

            return rooms;
        } catch (IOException ex) {
            return null;
        }
    }

    private int getCurrenGuestCount(Room room) {
        int count = 0;
        for (GuestInfo gi : guestsInfo) {
            if (gi.getRoom().equals(room) && gi.getStillLiving()) {
                count++;
            }
        }

        return count;
    }

    public void checkInGuest(Room room, Guest guest, Date arrivalDate, Date departureDate) {
        if (!(room.getCurrentGuestCount() < room.getCapacity())) {
            System.out.println(new StringBuilder(Literals.roomNoFreePlaces).append("in Entity.Room"));
        }

        GuestInfo gi = new GuestInfo(arrivalDate, departureDate, guest, room);
        room.setStatus(RoomStatus.reserved);
        guestsInfo.add(gi);
    }

    public void checkOutGuest(Room room, Guest guest) {
        room.removeGuest(guest);
    }

    public void PrintGuestsSortedBy(GuestInfoSortType guestsSortType) {
        ArrayList<GuestInfo> guests = new ArrayList<>();
        for (GuestInfo gi : guestsInfo) {
            if (gi.getStillLiving()) {
                guests.add(gi);
            }
        }

        PrintGuests(SortGuestsBy(guests, guestsSortType), "Guests sorted by " + guestsSortType.toString() + ":");
    }

    public ArrayList<Room> getRoomsCountFreedByDate(Date date) {
        ArrayList<Room> freeRoomsByDate = new ArrayList<>();

        for (GuestInfo gi : guestsInfo) {
            if (gi.getStillLiving()) {
                if (gi.getDepartureDate().compareTo(date) == -1) {
                    freeRoomsByDate.add(gi.getRoom());
                }
            }
        }

        //TODO: decide whose responsibility it is (return count + (this.capacity - getCurrenGuestCount());)
        return freeRoomsByDate;
    }

    public void getPaymentForGuest() {
        int price = BillingService.calculateGuestStaying(guestsInfo.get(0));
        System.out.println("Price: " + price);
    }

    public ArrayList<Guest> getLastThreeGuests() {
        ArrayList<Guest> lastThreeGuests = new ArrayList<Guest>();
        for (int i = guestsInfo.size(), k = 0; i > 0 && k < 3; i--, k++) {
            Guest guest = guestsInfo.get(i - 1).getGuest();
            System.out.println(guest + guestsInfo.get(i - 1).getDepartureDate().toString());
        }

        return lastThreeGuests;
    }

    private ArrayList<GuestInfo> SortGuestsBy(ArrayList<GuestInfo> guests, GuestInfoSortType guestSortType) {
        switch (guestSortType) {
            case Name:
                guests.sort(new GuestInfoNameComporator());
                return guests;
            default:
                return null;
        }
    }

    private void PrintGuests(ArrayList<GuestInfo> guests, String message) {
        System.out.println(message);
        for (GuestInfo gi : guests) {
            System.out.println(gi);
        }
    }
}