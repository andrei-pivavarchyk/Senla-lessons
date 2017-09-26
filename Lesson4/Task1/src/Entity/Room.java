package Entity;

import java.util.ArrayList;
import java.util.Date;

import Services.Literals;


public class Room {
    private int number;
    private int capacity;
    private int stars;
    private int cost;
    private RoomStatus status = RoomStatus.free;
    private ArrayList<GuestInfo> guestsInfo;

    public Room(int number, int cost, int capacity, int stars) {
        this.number = number;
        this.cost = cost;
        this.capacity = capacity;
        this.stars = stars;
        this.guestsInfo = new ArrayList<>(capacity);
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
        this.status = status;
    }

    private int getCurrenGuestCount() {
        int count = 0;
        for (GuestInfo gi : guestsInfo) {
            if (gi.getStillLiving()) {
                count++;
            }
        }

        return count;
    }


    public void addGuest(Guest guest, Date departureDate) {
        if (this.capacity > this.getCurrenGuestCount()) {
            GuestInfo gi = new GuestInfo(new Date(), departureDate, guest);
            this.guestsInfo.add(gi);
            guest.setGuestRoom(this);
            guest.setGuestInfo(gi);

            if (this.capacity == this.getCurrenGuestCount()) {
                this.status = RoomStatus.reserved;
            }
        } else {
            System.out.println(new StringBuilder(Literals.roomNoFreePlaces).append("in Entity.Room"));
        }
    }

    public void outGuest(Guest guest) {
        for (int i = 0; i < guestsInfo.size(); i++) {
            if (this.guestsInfo.get(i).getGuest().equals(guest)) {
                guestsInfo.get(i).setIsStillLiving(false);
            }
        }
    }

    public ArrayList<GuestInfo> getCurrenGuestInfo() {
        return this.guestsInfo;
    }

    public int getFutureCountFreePlacesByDate(Date date) {
        int count = 0;

        for (GuestInfo gi : guestsInfo) {
            if (gi.getStillLiving()) {
                if (gi.getDepartureDate().compareTo(date) == -1) {
                    count++;
                }
            }
        }

        return count + (this.capacity - getCurrenGuestCount());
    }

    public ArrayList<Guest> printLastThreeGuests() {
        ArrayList<Guest> lastThreeGuests = new ArrayList<Guest>();
        for (int i = this.guestsInfo.size(), k = 0; i > 0 && k < 3; i--, k++) {
            Guest guest = this.guestsInfo.get(i - 1).getGuest();
            System.out.println(guest + this.guestsInfo.get(i - 1).getDepartureDate().toString());
        }

        return lastThreeGuests;
    }

    public String toString() {
        return String.format("Room number: %s status: %s cost: %s capacity: %s stars: %s", this.number, this.status, this.cost, this.capacity, this.stars);
    }
}