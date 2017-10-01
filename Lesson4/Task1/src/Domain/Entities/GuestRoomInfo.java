package Domain.Entities;

import java.util.Date;

public class GuestRoomInfo extends Entity {
    private Date arrivalDate;
    private Date departureDate;
    private Guest guest;
    private Room room;
    private Boolean isStillLiving;

    public GuestRoomInfo(Date arrivalDate, Date departureDate, Guest guest, Room room) {
        super(1);
        if (departureDate.compareTo(arrivalDate) == -1) {
            throw new IllegalArgumentException("Departure date cannot be less than arrival date");
        }

        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.guest = guest;
        this.room = room;
        this.isStillLiving = true;
    }

    public Guest getGuest() {
        return this.guest;
    }

    public Room getRoom() {
        return this.room;
    }

    public Date getDepartureDate() {
        return this.departureDate;
    }

    public void setDepartureDate(Date date) {
        this.departureDate = date;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public Boolean getStillLiving() {
        return isStillLiving;
    }

    public void setIsStillLiving(Boolean b) {
        this.isStillLiving = b;
    }

    public String toString() {
        return String.format("Guest: %s. Room number: %s.", guest.getSurName(), room.getNumber());
    }
}