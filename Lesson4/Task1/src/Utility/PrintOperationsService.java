package Utility;

import Comparator.GuestInfoNameComparator;
import Comparator.RoomCapacityCorporator;
import Comparator.RoomCostComparator;
import Comparator.RoomStarsComparator;
import Domain.Entities.GuestRoomInfo;
import Domain.Entities.Room;
import Sorting.GuestInfoSortType;
import Sorting.RoomSortType;

import java.util.ArrayList;

public class PrintOperationsService {
    public static ArrayList<Room> SortRoomsBy(ArrayList<Room> rooms, RoomSortType roomSortType) {
        switch (roomSortType) {
            case Cost:
                rooms.sort(new RoomCostComparator());
                return rooms;
            case Capacity:
                rooms.sort(new RoomCapacityCorporator());
                return rooms;
            case Stars:
                rooms.sort(new RoomStarsComparator());
                return rooms;
            default:
                return null;
        }
    }

    public static void PrintRooms(ArrayList<Room> rooms, String message) {
        System.out.println(message);
        for (Room r : rooms) {
            System.out.println(r);
        }
    }

    public static ArrayList<GuestRoomInfo> SortGuestsBy(ArrayList<GuestRoomInfo> guests, GuestInfoSortType guestSortType) {
        switch (guestSortType) {
            case Name:
                guests.sort(new GuestInfoNameComparator());
                return guests;
            default:
                return null;
        }
    }

    public static void PrintGuests(ArrayList<GuestRoomInfo> guests, String message) {
        System.out.println(message);
        for (GuestRoomInfo gi : guests) {
            System.out.println(gi);
        }
    }

    public static void PrintGuestsDepartureDates(ArrayList<GuestRoomInfo> guests, String message) {
        System.out.println(message);
        for (GuestRoomInfo gi : guests) {
            System.out.println("Guest: " + gi.getGuest().getSurName() + " Departure date:" + gi.getDepartureDate());
        }
    }
}
