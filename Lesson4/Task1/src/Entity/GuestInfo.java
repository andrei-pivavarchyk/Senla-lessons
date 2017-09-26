package Entity;

import Entity.Guest;

import java.util.Date;

public class GuestInfo {
    private Date arrivalDate;
    private Date departureDate;
    private Guest guest;
    private Boolean isStillLiving;

    public GuestInfo(Date arrivalDate, Date departureDate, Guest guest) {
        if (departureDate.compareTo(arrivalDate) == -1) {
            throw new IllegalArgumentException("Departure date cannot be less than arrival date");
        }

        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.guest = guest;
        this.isStillLiving = true;
    }

    public Guest getGuest() {
        return this.guest;
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
}
