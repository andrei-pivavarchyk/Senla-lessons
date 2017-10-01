package Domain.Entities;

public class Room extends Entity {
    private int number;
    private int capacity;
    private int stars;
    private int cost;
    private int currentNumberOfGuests;
    private RoomStatus status;

    public Room(int number, int cost, int capacity, int stars, int id) {
        super(id);
        this.number = number;
        this.cost = cost;
        this.capacity = capacity;
        this.stars = stars;
        this.status = RoomStatus.free;
    }

    public int getCurrentNumberOfGuests() {
        return currentNumberOfGuests;
    }

    public void setCurrentNumberOfGuests(int currentNumberOfGuests) {
        this.currentNumberOfGuests = currentNumberOfGuests;
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

    public RoomStatus getStatus() {
        return this.status;
    }

    public void setStatus(RoomStatus status) {
        if (status == RoomStatus.repairable) {
            if (this.status == RoomStatus.reserved) {
                throw new IllegalArgumentException("Room is not empty!");
            }
        }

        this.status = status;
    }

    public String toString() {
        return String.format("Room number: %s status: %s cost: %s capacity: %s stars: %s", this.number, this.status, this.cost, this.capacity, this.stars);
    }
}