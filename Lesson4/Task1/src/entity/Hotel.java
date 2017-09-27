package entity;

import guestService.Service;
import services.HotelService;
import java.util.ArrayList;


public class Hotel extends ArrayList<Room> {
    private String name;
    private ArrayList<Room> allRooms;
    private ArrayList<Guest> allGuests;
    private ArrayList<Service> allServices;
    private HotelService hotelService;

    public Hotel(String name) {
        this.name = name;
        this.allGuests = new ArrayList<Guest>();
        this.allRooms = new ArrayList<Room>();
        this.allServices = new ArrayList<Service>();


    }
    public ArrayList<Room> getAllRooms() {
        return this.allRooms;
    }
    public ArrayList<Service> getAllServices() {
        return this.allServices;
    }
    public ArrayList<Guest> getAllGuests() {
        return allGuests;
    }
    public void setHotelService(HotelService hotel){
        this.hotelService=hotel;
    }
    public HotelService getHotelService(){return this.hotelService;}




}
