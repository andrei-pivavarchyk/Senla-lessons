
package comparator;

import entity.Guest;
import entity.GuestRoomInfo;

import java.util.Comparator;
import java.util.Date;

public class GuestRoomInfoDateComparator implements Comparator<GuestRoomInfo> {

    @Override
    public int compare(GuestRoomInfo guest1, GuestRoomInfo guest2) {

        if (guest1.getDepartureDate().equals(null) && guest2.getDepartureDate().equals(null)) {
            return 0;
        } else if (guest1.getDepartureDate().equals(null)) {
            return -1;
        } else if (guest2.getDepartureDate().equals(null)) {

            return 1;
        }

        Date guest1Date = guest1.getDepartureDate();
        Date guest2Date = guest2.getDepartureDate();
        return guest1Date.compareTo(guest2Date);
    }
}
