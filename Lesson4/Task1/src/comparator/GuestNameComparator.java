
package comparator;

import entity.Guest;

import java.util.Comparator;

public class GuestNameComparator implements Comparator<Guest> {

    @Override
    public int compare(Guest guest1, Guest guest2) {
        try {
            String guest1Name = guest1.getName();
            String guest2Name = guest2.getName();
            return guest1Name.compareTo(guest2Name);
        } catch (Exception e) {
            System.out.println(e);
        }

        return 0;
    }
}
