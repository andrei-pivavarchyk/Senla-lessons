
package comparator;

import entity.Guest;

import java.util.Comparator;

public class GuestNameComparator implements Comparator<Guest> {

    @Override
    public int compare(Guest guest1, Guest guest2) {


        if (guest1.getName()==null &&  guest2.getName()==null) {
            return 0;
        }

        if (guest1.getName()==null) {
            return -1;
        }

        if (guest2.getName()==null) {

            return 1;
        }

        String guest1Name = guest1.getName();
        String guest2Name = guest2.getName();
        return guest1Name.compareTo(guest2Name);

    }
}
