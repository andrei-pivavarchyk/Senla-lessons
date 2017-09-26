package Entity;

import Services.Literals;
import Services.PrintIOperations;

import java.util.ArrayList;
import java.util.Date;

public class Hotel extends ArrayList<Room> {
    private String name;
    private int freeRoomsCount;
    private int allGuestsCount;
    private ArrayList<Room> allRooms;
    private ArrayList<Guest> allGuests;

    public Hotel(String name) {
        this.name = name;
        this.allGuests = new ArrayList<>();
        this.allRooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        this.allRooms.add(room);
    }

    public void removeRoom(Room room) {
        if (allRooms.contains(room)) {
            this.allRooms.remove(room);
        } else {
            System.out.println(Literals.guestNotFoundInRoom);
        }
    }

    public ArrayList<Room> getAllRooms() {
        return this.allRooms;
    }

    public ArrayList<Room> getFreeRooms() {
        ArrayList<Room> freeRooms = new ArrayList<>();
        for (int i = 0; i < allRooms.size(); i++) {
            if (allRooms.get(i).getStatus().equals(RoomStatus.free)) {
                freeRooms.add(this.allRooms.get(i));
            }
        }

        return freeRooms;
    }


    public void printAllRooms() {
        PrintIOperations.printAllRooms(this.allRooms);
    }

    public void printFreeRooms() {
        PrintIOperations.printAllRooms(this.getFreeRooms());
    }

    public int getFreeRoomsCount() {
        return this.getFreeRooms().size();
    }


    public int getAllGuestsCount() {
        return this.allGuests.size();
    }

    public int getAllRoomsCount() {
        return this.allRooms.size();
    }


    public ArrayList<Room> getFreeRoomsByDate(Date date) {
        ArrayList<Room> freeRoomsByDate = new ArrayList<Room>();
        for (int i = 0; i < allRooms.size(); i++) {
            if (this.allRooms.get(i).getFutureCountFreePlacesByDate(date) != 0) {
                freeRoomsByDate.add(this.allRooms.get(i));
            }
        }
        return freeRoomsByDate;
    }

    public ArrayList<Guest> getAllGuests() {
        return allGuests;
    }

    public void addGuestToRoom(int roomNumber, Guest guest, int year, int month, int day) {


    }

}
