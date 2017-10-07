package services;


import Storage.GuestServiceStorage;
import Storage.IGuestServiceStorage;
import Storage.IServiceStorage;
import comparator.GuestServiceInfoCostComparator;

import comparator.GuestServiceInfoDateComparator;
import comparator.ServiceCostComparator;
import entity.Guest;
import entity.GuestServiceInfo;
import entity.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ServiceService implements IServiceService {

    private IGuestServiceStorage guestServiceStorage;
    private IServiceStorage serviceStorage;
    private int guestServiceInfoCount = 0;

    public ServiceService(IGuestServiceStorage guestServiceStorage, IServiceStorage serviceStorage) {

        this.guestServiceStorage = guestServiceStorage;
        this.serviceStorage = serviceStorage;
    }


    public void addGuestService(Guest guest, Service service, int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month + 1, day);
        Date serviceDate = calendar.getTime();
        GuestServiceInfo guestServiceInfo = new GuestServiceInfo(guestServiceInfoCount, guest, service, serviceDate);
        this.guestServiceStorage.addEntity(guestServiceInfo);
        guestServiceInfoCount++;
    }

    public ArrayList<GuestServiceInfo> getAllGuestServicesInfo(Guest guest) {
        ArrayList<GuestServiceInfo> allGuestServicesInfo = new ArrayList<GuestServiceInfo>();
        for (GuestServiceInfo guestServiceInfo : this.guestServiceStorage.getAllEntities()) {
            if (guestServiceInfo.getGuest().equals(guest)) {
                allGuestServicesInfo.add(guestServiceInfo);
            }
        }
        return allGuestServicesInfo;
    }

    public ArrayList<GuestServiceInfo> getAllGuestServicesInfoSortedByCost(Guest guest) {
        ArrayList<GuestServiceInfo> copyArray = new ArrayList<GuestServiceInfo>(this.getAllGuestServicesInfo(guest));
        copyArray.sort(new GuestServiceInfoCostComparator());
        return copyArray;


    }

    public ArrayList<GuestServiceInfo> getAllGuestServicesInfoSortedByDate(Guest guest) {
        ArrayList<GuestServiceInfo> copyArray = new ArrayList<GuestServiceInfo>(this.getAllGuestServicesInfo(guest));
        copyArray.sort(new GuestServiceInfoDateComparator());
        return copyArray;
    }

    public ArrayList<Service> getAllServicesSortedByCost(){
      ArrayList<Service> allServices=new ArrayList<Service>(this.serviceStorage.getAllEntities());
           allServices.sort(new ServiceCostComparator());
      return allServices;
    }

    public void addService(Service service) {
        this.serviceStorage.addEntity(service);
    }

    public IServiceStorage getServiceStorage() {
        return serviceStorage;
    }
}
