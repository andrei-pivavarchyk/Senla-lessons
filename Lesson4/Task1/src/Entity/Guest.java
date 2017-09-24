package Entity;

import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Guest {
    private String name;
    private String surName;
    private Room guestRoom;
    private GuestInfo guestInfo;


    private int pay;
    private Service allGuestService;


    public Guest(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }

    public String getName() {
        return this.name;
    }
    public String getSurName(){
        return this.surName;
    }

    public Date getDepartureDate() {
        Date departureDate = new Date();
        for (int i = 0; i < this.guestRoom.getCurrenGuestInfo().size(); i++) {
            if (this.equals(this.guestRoom.getCurrenGuestInfo().get(i).getGuest())) {
                departureDate = this.guestRoom.getCurrenGuestInfo().get(i).getDepartureDate();
            }
        }
        return departureDate;


    }
    public void setGuestInfo(GuestInfo guestInfo){
        this.guestInfo=guestInfo;
    }
    public GuestInfo getGuestInfo(){return this.guestInfo;}

    public long getPay() {
        GregorianCalendar firstCalendar = new GregorianCalendar();
        GregorianCalendar secondDate = new GregorianCalendar();
        long allDaysLeaving = 0;


        for (int i = 0; i < this.guestRoom.getCurrenGuestInfo().size(); i++) {
            if (this.guestRoom.getCurrenGuestInfo().get(i).getGuest().equals(this)) {

                firstCalendar.setTime(this.guestRoom.getCurrenGuestInfo().get(i).getDepartureDate());
                secondDate.setTime(this.guestRoom.getCurrenGuestInfo().get(i).getArrivalDate());

                allDaysLeaving = (int) (firstCalendar.getTimeInMillis() - secondDate.getTimeInMillis());



            }
        }

        return allDaysLeaving / 86400000 * this.guestRoom.getCost();
    }





    public Room getGuestRoom(){
        return this.guestRoom;
    }
    public void setGuestRoom(Room room){
        this.guestRoom=room;
    }
}
