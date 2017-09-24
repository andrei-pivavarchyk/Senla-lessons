package Sorting;

import Comparator.GuestDateComporator;
import Comparator.GuestNameComporator;
import Entity.Guest;

import java.util.ArrayList;

public class GuestSorting {

    public static ArrayList guestNameSorting(ArrayList<Guest> ListOfGuests){
        ArrayList<Guest> copyArray= new ArrayList<Guest>(ListOfGuests);
        copyArray.sort(new GuestNameComporator());
        return copyArray;
    }

    public static ArrayList guestDepartureDateSorting(ArrayList<Guest> ListOfGuests){
        ArrayList<Guest> copyArray= new ArrayList<Guest>(ListOfGuests);
        copyArray.sort(new GuestDateComporator());
        return copyArray;
    }

}
