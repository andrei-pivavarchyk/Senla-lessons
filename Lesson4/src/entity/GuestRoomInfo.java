package entity;


import java.util.*;

public class GuestRoomInfo extends Entity {

    private Date arrivalDate;
    private Date departureDate;
    private Guest guest;
    private Room room;
    private Boolean isStillLiving;


    public GuestRoomInfo(int id, Date arrivalDate, Guest guest, Room room, int year, int month, int day) {
        super(id);
        this.arrivalDate = arrivalDate;
        this.guest = guest;
        this.room = room;
        this.isStillLiving = true;
        Calendar calendar = new GregorianCalendar(year, month, day);
        this.departureDate = calendar.getTime();

    }


    public Boolean getStillLiving() {
        return isStillLiving;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public Guest getGuest() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setStillLiving(Boolean stillLiving) {
        isStillLiving = stillLiving;
    }

    public String toString() {
        return String.format("Guest: %s. Room number: %s.", guest, room.getNumber());
    }
}
