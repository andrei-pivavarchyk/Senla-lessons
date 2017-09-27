package entity;

import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Guest {
    private String name;
    private String surname;
    private Room guestRoom;
    private GuestInfo guestInfo;
    private int pay;
    private Service allGuestService;

    public Guest(String name, String surName) {
        this.name = name;
        this.surname = surName;
        System.out.println(new StringBuilder("Guest ").append(this.name).append(" ").append(this.surname).append(" was created"));
    }

    public String getName() {
        return this.name;
    }
    public String getSurName(){
        return this.surname;
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
        long firstDate = new GregorianCalendar().getTime().getTime();
        long secondDate = this.getGuestInfo().getDepartureDate().getTime();
        long allDaysLeaving = (secondDate-firstDate)/86400000;
        return (secondDate-firstDate)/86400000;
    }
    public Room getGuestRoom(){
        return this.guestRoom;
    }
    public void setGuestRoom(Room room){
        this.guestRoom=room;
    }
    public String toString(){
        return String.format("Guest  %s %s guest room number: %s ",this.name,this.surname,this.guestRoom.getNumber());
    }
}
