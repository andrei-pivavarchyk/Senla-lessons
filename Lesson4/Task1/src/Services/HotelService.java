package Services;

import Comparator.RoomCapacityCorporator;
import Comparator.RoomCostComparator;
import Comparator.RoomStarsComparator;
import Entity.*;

import java.util.ArrayList;
import java.util.Date;

public class HotelService {
    private Hotel hotel;
    private RoomService roomService;

    public HotelService(Hotel hotel, RoomService roomService) {
        this.hotel = hotel;
        this.roomService = roomService;
    }

    public void PrintRoomsSortedBy(RoomSortType roomSortType) {
        ArrayList<Room> copiedArray = new ArrayList<>(hotel.getRooms());
        PrintRooms(SortRoomsBy(copiedArray, roomSortType), "Rooms sorted by " + roomSortType.toString() + ":");
    }

    public void PrintFreeRoomsSortedBy(RoomSortType roomSortType) {
        ArrayList<Room> copiedArray = new ArrayList<>(getFreeRooms());
        PrintRooms(SortRoomsBy(copiedArray, roomSortType), "Rooms sorted by " + roomSortType.toString() + ":");
    }

    public int getRoomsCount() {
        return hotel.getRooms().size();
    }

    public int getFreeRoomsCount() {
        return getFreeRooms().size();
    }

    public int getGuestsCount() {
        return hotel.getGuests().size();
    }

    public void addRoom(Room room) {
        hotel.getRooms().add(room);
    }

    public void removeRoom(Room room) {
        if (hotel.getRooms().contains(room)) {
            hotel.getRooms().remove(room);
        } else {
            System.out.println(Literals.guestNotFoundInRoom);
        }
    }

    public void printFreeRoomsByDate(Date date) {
        ArrayList<Room> freeRoomsByDate = new ArrayList<>();
        freeRoomsByDate.addAll(getFreeRooms());
        freeRoomsByDate.addAll(roomService.getRoomsCountFreedByDate(date));
        PrintRooms(SortRoomsBy(freeRoomsByDate,RoomSortType.Capacity), "Rooms free by date:");
    }

    public void addGuestToRoom(int roomNumber, Guest guest, int year, int month, int day) {
        //NOT IMPLEMENTED YET
    }

    public void getRoomDetails(Room room) {
        System.out.println(room);
    }

    private ArrayList<Room> getFreeRooms() {
        ArrayList<Room> freeRooms = new ArrayList<>();
        for (Room r : hotel.getRooms()) {
            if (r.getStatus().equals(RoomStatus.free)) {
                freeRooms.add(r);
            }
        }

        return freeRooms;
    }

    private ArrayList<Room> SortRoomsBy(ArrayList<Room> rooms, RoomSortType roomSortType) {
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

    private void PrintRooms(ArrayList<Room> rooms, String message) {
        System.out.println(message);
        for (Room r : rooms) {
            System.out.println(r);
        }
    }
}