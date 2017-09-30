package Services;

import Entity.Guest;
import Entity.Service;
import Entity.ServiceGuestInfo;

import java.util.ArrayList;
import java.util.Date;

public class ServiceService {
    private ArrayList<ServiceGuestInfo> serviceGuestInfos = new ArrayList<>();

    public void addServiceToGuest(Guest guest, Service service) {
        serviceGuestInfos.add(new ServiceGuestInfo(guest, service, new Date(), false));
    }

    public void printServiceInfoForGuest(Guest guest) {
        System.out.println("Services for guests:");
        for (ServiceGuestInfo sgi : serviceGuestInfos) {
            if (sgi.getGuest().equals(guest)) {
                System.out.println(sgi);
            }
        }
    }
}