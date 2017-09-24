package Entity;

import Entity.Guest;

import java.util.Date;

public class GuestInfo {
    private Date arrivalDate;
    private Date departureDate;
    private Guest guest;

    public GuestInfo(Date arrivalDate,Date departureDate,Guest guest){
        if(departureDate.compareTo(arrivalDate)==-1){
            throw new IllegalArgumentException("Departure date cannot be less than arrival date");
        }
        this.arrivalDate=arrivalDate;
        this.departureDate=departureDate;
        this.guest=guest;
    }

    public Guest getGuest(){
        return this.guest;
    }
    public Date getDepartureDate(){
        return this.departureDate;
    }

    public boolean roomFreeByDate(Date date){
        if(this.departureDate.compareTo(date)==1){
            return true;
        }
        else{return false;}
    }
    public Date getArrivalDate(){
        return arrivalDate;
    }
    public void setDepartureDate(Date date){
        this.departureDate=date;
    }
}
