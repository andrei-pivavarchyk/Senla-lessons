package entity;

import java.util.ArrayList;
import java.util.Date;

public class Room extends Entity {
    private int number;
    private int capacity;
    private int stars;
    private int cost;
    private RoomStatus status = RoomStatus.FREE;
    private ArrayList<Guest> guests;


    public Room(int id, int number, int cost, int capacity, int stars) {
        super(id);
        this.number = number;
        this.cost = cost;
        this.capacity = capacity;
        this.stars = stars;
        this.guests = new ArrayList<Guest>(capacity);
    }


    public int getCost() {
        return this.cost;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getStars() {
        return this.stars;
    }

    public int getNumber() {
        return this.number;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    public ArrayList<Guest> getGuests() {
        return guests;
    }

    public String toString() {
        return String.format("Room number: %s cost: %s capacity: %s stars: %s", this.number, this.cost, this.capacity, this.stars);
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setGuests(ArrayList<Guest> guests) {
        this.guests = guests;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
