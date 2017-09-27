package entity;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import services.Literals;

public class Room {
    private int number;
    private int capacity;
    private RoomStatus status = RoomStatus.free;
    private int stars;
    private int cost;
    private ArrayList<GuestInfo> guestsInfo;
    private Hotel hotel;


    public Room(int number, int cost, int capacity, int stars) {
        this.number = number;
        this.cost = cost;
        this.capacity = capacity;
        this.stars = stars;
        this.guestsInfo = new ArrayList<GuestInfo>(capacity);
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    public RoomStatus getStatus() {
        return this.status;
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
            this.hotel.getAllGuests().add(guest);
            this.status = RoomStatus.reserved;

            System.out.println(new StringBuilder("Guest ").append(guest.getName()).append(" ").append(guest.getSurName()).append(" was added"));

        } else {
            System.out.println(Literals.roomNoFreePlaces);
        }

    }

    public void outGuest(Guest guest) {
        for (int i = 0; i < guestsInfo.size(); i++) {

            if (this.guestsInfo.get(i).getGuest().equals(guest)) {
                guestsInfo.get(i).setIsStillLiving(false);
            }
        }
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return this.cost;
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

    public ArrayList<GuestInfo> getCurrenGuestInfo() {
        return this.guestsInfo;

    }

    public Date getDateDeparture() {
        if(this.status.equals(RoomStatus.free)){
            return null;
        }
        else{
            return this.guestsInfo.get(0).getDepartureDate();
        }
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public ArrayList<Guest> printLastThreeGuests() {
        ArrayList<Guest> lastThreeGuests = new ArrayList<Guest>();
        for (int i = this.guestsInfo.size(), k = 0; i > 0 && k < 3; i--, k++) {
            Guest guest = this.guestsInfo.get(i - 1).getGuest();
            StringBuilder text=new StringBuilder(guest.toString());
            text.append("Departure date: ").append( this.guestsInfo.get(i - 1).getDepartureDate().toString());
            text.append("Arribal date: ").append( this.guestsInfo.get(i - 1).getArrivalDate().toString());

            System.out.println(text );
            // lastThreeGuests.add(this.guestsInfo.get(i-1).getGuest());

        }
        return lastThreeGuests;

    }

    public String toString() {
        return String.format("Room number: %s cost: %s capacity: %s stars: %s", this.number, this.cost, this.capacity, this.stars);
    }



}
