
package hotel.comparator;

import hotel.entity.GuestRoomInfo;
import hotel.services.NullCheck;

import java.util.Comparator;
import java.util.Date;

public class GuestRoomInfoDateComparator implements Comparator<GuestRoomInfo> {

    @Override
    public int compare(GuestRoomInfo guest1, GuestRoomInfo guest2) {

        int nullParameter = NullCheck.check(guest1.getDepartureDate(), guest2.getDepartureDate());
        if (nullParameter == 2) {
            Date guest1Date = guest1.getDepartureDate();
            Date guest2Date = guest2.getDepartureDate();
            return guest1Date.compareTo(guest2Date);

        } else {
            return nullParameter;
        }
    }
}
