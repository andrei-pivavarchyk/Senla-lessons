package entity;

import guestService.Service;
import services.Literals;
import java.util.ArrayList;
import java.util.Calendar;

public class Hotel extends ArrayList<Room> {
    private String name;
    private ArrayList<Room> allRooms;
    private ArrayList<Guest> allGuests;
    private ArrayList<Service> allServices;

    public Hotel(String name) {
        this.name = name;
        this.allGuests = new ArrayList<Guest>();
        this.allRooms = new ArrayList<Room>();
        this.allServices = new ArrayList<Service>();


    }


    public void addRoom(Room room) {
        this.allRooms.add(room);
        room.setHotel(this);
        System.out.println(new StringBuilder("Room number: ").append(room.getNumber()).append(" was added"));
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
        ArrayList<Room> freeRooms = new ArrayList<Room>();
        for (int i = 0; i < allRooms.size(); i++) {
            if (allRooms.get(i).getStatus().equals(RoomStatus.free)) {
                freeRooms.add(this.allRooms.get(i));
            }

        }
        return freeRooms;
    }

    private Room findRoomByNumber(int roomNumber) {
        Room currentRoom;
        for (Room room : this.allRooms) {
            if (room.getNumber() == roomNumber) {
                currentRoom = room;
                return room;
            }
        }
        return null;
    }

    public void addGuestToRoom(int roomNumber, Guest guest, int year, int month, int day) {
        Room currentRoom = this.findRoomByNumber(roomNumber);
        if (currentRoom != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month, day);
            currentRoom.addGuest(guest, calendar.getTime());
        } else {
            System.out.print("There is no room with this number");
        }
    }

    public int getFreeRoomsCount() {
        return this.getFreeRooms().size();
    }

    public ArrayList<Guest> getAllGuests() {
        return allGuests;
    }

    public void addService(Service service) {
        this.allServices.add(service);
    }

    public ArrayList<Service> getAllServices() {
        return this.allServices;
    }
}
