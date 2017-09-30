package Services;

import Domain.Entities.Guest;
import Domain.Entities.Service;
import Domain.Entities.ServiceGuestInfo;

import java.util.ArrayList;
import java.util.Date;

public class ServiceService {
    private ArrayList<ServiceGuestInfo> serviceRoomGuestInfos = new ArrayList<>();

    public void addServiceToGuest(Guest guest, Service service) {
        serviceRoomGuestInfos.add(new ServiceGuestInfo(guest, service, new Date(), false));
    }

    public void printServiceInfoForGuest(Guest guest) {
        System.out.println("Services for guests:");
        for (ServiceGuestInfo sgi : serviceRoomGuestInfos) {
            if (sgi.getGuest().equals(guest)) {
                System.out.println(sgi);
            }
        }
    }
}