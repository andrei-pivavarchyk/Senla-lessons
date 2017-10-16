
package comparator;

import entity.Guest;
import services.NullCheck;

import java.util.Comparator;

public class GuestNameComparator implements Comparator<Guest> {

    @Override
    public int compare(Guest guest1, Guest guest2) {

        int nullParameter = NullCheck.check(guest1.getName(), guest2.getName());
        if (nullParameter == 2) {
            String guest1Name = guest1.getName();
            String guest2Name = guest2.getName();
            return guest1Name.compareTo(guest2Name);
        } else {
            return nullParameter;
        }
    }
}
