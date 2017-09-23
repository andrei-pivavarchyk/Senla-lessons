

import java.util.ArrayList;

public class Hotel {
    private String name;

    private int freeRoomsCount;
    private int allGuestsCount;

    private ArrayList<Room> allRooms;
    private ArrayList<Room> freeRooms;
    private ArrayList<Guest> allGuests;

    public Hotel(String name) {
        this.name = name;
        this.allGuests = new ArrayList<Guest>();
        this.allRooms = new ArrayList<Room>();
        this.freeRooms = new ArrayList<Room>();


    }


    public void addRoom(Room room) {
        this.allRooms.add(room);
    }

    public void removeRoom(Room room) {
        this.allRooms.remove(room);
    }

    public void addGuest(Guest guest,Room room){
        room.addGuest(guest);
    }
    public void outGuest(Guest guest,Room room){

        room.outGuest(guest);

    }

    public ArrayList<Room> getAllRooms(){
        return this.allRooms;
    }

}
