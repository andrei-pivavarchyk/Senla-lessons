
package hotel.comparator;

import hotel.entity.Guest;
import hotel.services.NullCheck;

import java.io.Serializable;
import java.util.Comparator;

public class GuestNameComparator implements Comparator<Guest>,Serializable {

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
