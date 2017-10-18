
package hotel.comparator;

import hotel.entity.GuestServiceInfo;
import hotel.services.NullCheck;

import java.util.Comparator;
import java.util.Date;

public class GuestServiceInfoDateComparator implements Comparator<GuestServiceInfo> {

    @Override
    public int compare(GuestServiceInfo service1, GuestServiceInfo service2) {

        int nullParameter = NullCheck.check(service1.getDate(), service2.getDate());

        if (nullParameter == 2) {
            Date service1Date = service1.getDate();
            Date service2Date = service2.getDate();
            return service1Date.compareTo(service2Date);
        } else {
            return nullParameter;
        }
    }
}
