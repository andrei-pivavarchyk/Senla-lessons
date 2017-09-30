package Entity;

import java.util.ArrayList;

public class Hotel extends Entity {
    private String name;
    private ArrayList<Room> rooms;
    private ArrayList<Guest> guests;
    private ArrayList<Service> services;

    public Hotel(String name) {
        this.name = name;
        this.rooms = new ArrayList<>();
        this.guests = new ArrayList<>();
        this.services = new ArrayList<>();
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public ArrayList<Guest> getGuests() {
        return guests;
    }

    public ArrayList<Service> getServices() {
        return services;
    }
}