package com.testHotel.services;

import com.testHotel.comparator.GuestServiceInfoCostComparator;
import com.testHotel.comparator.GuestServiceInfoDateComparator;
import com.testHotel.comparator.ServiceCostComparator;
import com.testHotel.entity.Guest;
import com.testHotel.entity.GuestServiceInfo;
import com.testHotel.entity.Service;
import com.testHotel.storage.IGuestServiceStorage;
import com.testHotel.storage.IServiceStorage;

import org.apache.log4j.Logger;

import java.io.Serializable;
import java.util.*;

public class ServiceService implements IServiceService,Serializable {

    private IGuestServiceStorage guestServiceStorage;
    private IServiceStorage serviceStorage;
    private int guestServiceInfoCount = 0;
    private final Comparator<GuestServiceInfo> COST_COMPARATOR= new GuestServiceInfoCostComparator();
    private final Comparator<GuestServiceInfo> DATE_COMPARATOR= new GuestServiceInfoDateComparator();
    private final Comparator<Service> SERVICE_COST_COMPARATOR=new ServiceCostComparator();
    public static final Logger log= Logger.getLogger(GuestService.class);

    public ServiceService(IGuestServiceStorage guestServiceStorage, IServiceStorage serviceStorage) {

        this.guestServiceStorage = guestServiceStorage;
        this.serviceStorage = serviceStorage;
        log.info("Service Service started");
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
        copyArray.sort(COST_COMPARATOR);
        return copyArray;
    }

    public ArrayList<GuestServiceInfo> getAllGuestServicesInfoSortedByDate(Guest guest) {
        ArrayList<GuestServiceInfo> copyArray = new ArrayList<GuestServiceInfo>(this.getAllGuestServicesInfo(guest));
        copyArray.sort(DATE_COMPARATOR);
        return copyArray;
    }

    public void addService(Service service) {
        this.serviceStorage.addEntity(service);
    }

    public List<Service> getAllHotelServices(){
        return this.serviceStorage.getAllEntities();

    }

    public ArrayList<Service> getAllHotelServicesSortedByCost(){
        ArrayList<Service> allServices=new ArrayList<Service>(this.getAllHotelServices());
        allServices.sort(SERVICE_COST_COMPARATOR);
        return allServices;
    }

}
