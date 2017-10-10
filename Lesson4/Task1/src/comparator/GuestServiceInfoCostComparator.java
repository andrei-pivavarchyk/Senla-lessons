
package comparator;

import entity.GuestServiceInfo;
import entity.Service;

import java.util.Comparator;

public class GuestServiceInfoCostComparator implements Comparator<GuestServiceInfo> {

    @Override
    public int compare(GuestServiceInfo service1, GuestServiceInfo service2) {

        Integer service1Cost = service1.getService().getCost();
        Integer service2Cost = service2.getService().getCost();
            return service1Cost.compareTo(service2Cost);

    }
}


