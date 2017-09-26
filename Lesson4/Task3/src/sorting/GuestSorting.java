package sorting;

import comparator.GuestDateComparator;
import comparator.GuestNameComparator;
import entity.Guest;

import java.util.ArrayList;

public class GuestSorting {

    public static ArrayList guestNameSorting(ArrayList<Guest> ListOfGuests){
        ArrayList<Guest> copyArray= new ArrayList<Guest>(ListOfGuests);
        copyArray.sort(new GuestNameComparator());
        return copyArray;
    }

    public static ArrayList guestDepartureDateSorting(ArrayList<Guest> ListOfGuests){
        ArrayList<Guest> copyArray= new ArrayList<Guest>(ListOfGuests);
        copyArray.sort(new GuestDateComparator());
        return copyArray;
    }

}
