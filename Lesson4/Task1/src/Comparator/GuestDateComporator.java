package Comparator;

import Domain.Entities.Guest;

import java.util.Comparator;

public class GuestDateComporator implements Comparator<Guest> {


    @Override
    public int compare(Guest guest1, Guest guest2) {
/*      Date guest1Date = guest1.getDepartureDate();
        Date guest2Date = guest2.getDepartureDate();*/
        return 1;
    }
}
