
package comparator;

import entity.GuestServiceInfo;
import entity.Service;

import java.util.Comparator;
import java.util.Date;

public class GuestServiceInfoDateComparator implements Comparator<GuestServiceInfo> {

    @Override
    public int compare(GuestServiceInfo service1, GuestServiceInfo service2) {

        if (service1.getDate().equals(null) && service2.getDate() .equals(null)) {
            return 0;
        } else if (service1.getDate().equals(null)) {
            return -1;
        } else if (service2.getDate().equals(null)) {

            return 1;
        }
        Date service1Date = service1.getDate();
        Date service2Date = service2.getDate();
        return service1Date.compareTo(service2Date);
    }
}
