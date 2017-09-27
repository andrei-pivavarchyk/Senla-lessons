package comparator;

import entity.Guest;

import java.util.Comparator;
import java.util.Date;

public class GuestDateComparator implements Comparator<Guest> {


    @Override
    public int compare(Guest guest1, Guest guest2) {
        Date guest1Date = guest1.getDepartureDate();
        Date guest2Date = guest2.getDepartureDate();
        return guest1Date.compareTo(guest2Date);


    }
}
