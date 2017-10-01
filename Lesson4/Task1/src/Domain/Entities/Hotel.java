package Domain.Entities;

import Domain.Services.IRoomService;

import java.util.ArrayList;

public class Hotel extends Entity {
    private String name;
    private ArrayList<Room> rooms;
    private ArrayList<Guest> guests;
    private ArrayList<Service> services;

    private IRoomService roomService;

    public Hotel(String name, int id, IRoomService roomService) {
        super(id);
        this.name = name;
        this.rooms = new ArrayList<>();
        this.guests = new ArrayList<>();
        this.services = new ArrayList<>();
        this.roomService = roomService;
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

    public void setName(String name) {
        this.name = name;
    }

    //IMPLEMENTATION:
    public void printListOfRooms(){

    }

    @Override
    public String toString() {
        return String.format("Hotel: %s.", name);
    }
}