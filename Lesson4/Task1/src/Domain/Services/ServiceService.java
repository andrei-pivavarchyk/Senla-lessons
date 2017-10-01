package Domain.Services;

import Domain.Contracts.IGuestServiceInfoRepository;
import Domain.Entities.Guest;
import Domain.Entities.GuestServiceInfo;
import Domain.Entities.Service;

import java.util.Date;

public class ServiceService {
    private IGuestServiceInfoRepository guestServiceInfoRepository;

    public ServiceService(IGuestServiceInfoRepository guestServiceInfoRepository) {
        this.guestServiceInfoRepository = guestServiceInfoRepository;
    }

    public void addServiceToGuest(Guest guest, Service service) {
        guestServiceInfoRepository.Create(new GuestServiceInfo(guest, service, new Date(), false));
    }

    public void printServiceInfoForGuest(Guest guest) {
        System.out.println("Services for guests:");
        for (GuestServiceInfo sgi : guestServiceInfoRepository.Fetch()) {
            if (sgi.getGuest().equals(guest)) {
                System.out.println(sgi);
            }
        }
    }
}