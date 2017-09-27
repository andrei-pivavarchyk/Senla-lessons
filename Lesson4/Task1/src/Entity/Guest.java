package Entity;

import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Guest {
    private String name;
    private String surname;

    public Guest(String name, String surName) {
        this.name = name;
        this.surname = surName;
    }

    public String getName() {
        return this.name;
    }
    public String getSurName() {
        return this.surname;
    }

/*    public long calculatePayForRoom() {
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

    public Date getDepartureDate() {
        Date departureDate = new Date();
        for (int i = 0; i < this.guestRoom.getCurrenGuestInfo().size(); i++) {
            if (this.equals(this.guestRoom.getCurrenGuestInfo().get(i).getGuest())) {
                departureDate = this.guestRoom.getCurrenGuestInfo().get(i).getDepartureDate();
            }
        }

        return departureDate;
    }*/

    public String toString() {
        return String.format("Guest Name: %s surname: %s", this.name, this.surname);
    }
}