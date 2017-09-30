package Domain.Entities;

import java.util.ArrayList;

public class Hotel extends Entity {
    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private ArrayList<Room> rooms;
    private ArrayList<Guest> guests;
    private ArrayList<Service> services;

    public Hotel(String name, int id) {
        super(id);
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

    @Override
    public String toString() {
        return String.format("Hotel: %s.",  name);
    }
}