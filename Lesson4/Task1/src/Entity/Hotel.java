package Entity;

import Services.Literals;
import Services.PrintIOperations;

import java.util.ArrayList;
import java.util.Date;

public class Hotel extends ArrayList<Room> {
    private String name;
    private ArrayList<Room> rooms;
    private ArrayList<Guest> guests;

    public Hotel(String name) {
        this.name = name;
        this.rooms = new ArrayList<>();
        this.guests = new ArrayList<>();
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }
    public ArrayList<Guest> getGuests() {
        return guests;
    }
}