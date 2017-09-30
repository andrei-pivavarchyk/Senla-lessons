package Entity;

import java.util.ArrayList;

public class Room extends Entity {
    private int number;
    private int capacity;
    private int stars;
    private int cost;
    private RoomStatus status;
    private ArrayList<Guest> guests;

    public Room(int number, int cost, int capacity, int stars) {
        this.number = number;
        this.cost = cost;
        this.capacity = capacity;
        this.stars = stars;
        this.status = RoomStatus.free;
        guests = new ArrayList<>();
    }

    public int getCost() {
        return this.cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getNumber() {
        return this.number;
    }

    public int getStars() {
        return this.stars;
    }

    public int getCurrentGuestCount() {
        return guests.size();
    }

    public RoomStatus getStatus() {
        return this.status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    //TODO: consider the possibility to move this logic up to the service
    public void addGuest(Guest guest) {
        if (guests.size() == capacity) {
            throw new IllegalArgumentException("Room is full.");
        }

        guests.add(guest);
        System.out.println("Guest was added.");
    }

    public void removeGuest(Guest guest) {
        if (!guests.contains(guest)) {
            System.out.println("Guest wasn't found");
            return;
        }

        guests.remove(guest);
        System.out.println("Guest was removed.");
    }

    public String toString() {
        return String.format("Room number: %s status: %s cost: %s capacity: %s stars: %s", this.number, this.status, this.cost, this.capacity, this.stars);
    }
}