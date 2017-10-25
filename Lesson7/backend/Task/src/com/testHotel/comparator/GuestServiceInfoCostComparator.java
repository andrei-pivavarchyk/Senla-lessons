
package com.testHotel.comparator;

import com.testHotel.entity.GuestServiceInfo;
import com.testHotel.services.NullCheck;

import java.io.Serializable;
import java.util.Comparator;

public class GuestServiceInfoCostComparator implements Comparator<GuestServiceInfo>,Serializable {

    @Override
    public int compare(GuestServiceInfo service1, GuestServiceInfo service2) {

        int nullParameter = NullCheck.check(service1.getService().getCost(), service2.getService().getCost());

        if (nullParameter == 2) {
            Integer service1Cost = service1.getService().getCost();
            Integer service2Cost = service2.getService().getCost();
            return service1Cost.compareTo(service2Cost);
        } else {
            return nullParameter;
        }

    }
}


