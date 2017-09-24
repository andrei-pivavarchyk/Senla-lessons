package Entity;

import java.util.ArrayList;
import java.util.Date;
import Services.Literals;



public class Room {
    private int number;
    private int capacity;
    private RoomStatus status = RoomStatus.free;
    private int stars;
    private int cost;
    private ArrayList<GuestInfo> currentGuestsInfo;
    private ArrayList<GuestInfo> oldGuestInfo;
    private Hotel hotel;


    public Room(int number, int cost, int capacity, int stars) {
        this.number = number;
        this.cost = cost;
        this.capacity = capacity;
        this.stars = stars;
        this.currentGuestsInfo = new ArrayList<GuestInfo>(capacity);
        this.oldGuestInfo = new ArrayList<GuestInfo>();


    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    public RoomStatus getStatus() {
        return this.status;
    }


    public void addGuest(Guest guest, Date departureDate) {


        if (this.capacity > this.currentGuestsInfo.size()) {
            GuestInfo gi = new GuestInfo(new Date(), departureDate, guest);
            this.currentGuestsInfo.add(gi);
            this.hotel.getAllGuests().add(guest);
            guest.setGuestRoom(this);
            guest.setGuestInfo(gi);


            if (this.capacity == this.currentGuestsInfo.size()) {
                this.status = RoomStatus.reserved;
            }


        } else {
            System.out.println(new StringBuilder(Literals.roomNoFreePlaces).append("in Entity.Room"));
        }

    }

    public void outGuest(Guest guest) {
        for (int i = 0; i < currentGuestsInfo.size(); i++) {
            if (this.currentGuestsInfo.get(i).getGuest().equals(guest)) {
                guest.getGuestInfo().setDepartureDate(new Date());
                this.oldGuestInfo.add(currentGuestsInfo.get(i));
                this.currentGuestsInfo.remove(i);
                this.hotel.getAllGuests().remove(guest);
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
        return this.currentGuestsInfo;

    }

    public int getFutureCountFreePlacesByDate(Date date) {
        int count = 0;
        for (int i = 0; i < currentGuestsInfo.size(); i++) {

            if (this.currentGuestsInfo.get(i).roomFreeByDate(date) == true) {
                count = count + 1;
            }

        }
        return count;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }


    public ArrayList<Guest> getlastThreeGuests() {

        ArrayList<Guest> lastThreeGuests = new ArrayList<Guest>();


        for(int i=0;i<this.oldGuestInfo.size()&&i<3;i++){
            lastThreeGuests.add(this.oldGuestInfo.get(i).getGuest());
        }


        return lastThreeGuests;



    }


}
