package com.testHotel.service;

import com.dependencyService.DependencyService;
import com.testHotel.comparator.GuestServiceInfoCostComparator;
import com.testHotel.comparator.GuestServiceInfoDateComparator;
import com.testHotel.comparator.ServiceCostComparator;
import com.testHotel.dao.IGuestServiceDAO;
import com.testHotel.dao.IServiceDAO;
import com.testHotel.entity.Guest;
import com.testHotel.entity.GuestServiceInfo;
import com.testHotel.entity.Service;
import org.apache.log4j.Logger;

import java.util.*;

public class ServiceService implements IServiceService {

    private IGuestServiceDAO guestServiceDAO=(IGuestServiceDAO) DependencyService.getDI().getInstance(IGuestServiceDAO.class);
    private int guestServiceInfoCount = 0;
    private static final Comparator<GuestServiceInfo> COST_COMPARATOR = new GuestServiceInfoCostComparator();
    private static final Comparator<GuestServiceInfo> DATE_COMPARATOR = new GuestServiceInfoDateComparator();
    private static final Comparator<Service> SERVICE_COST_COMPARATOR = new ServiceCostComparator();
    public static final Logger log = Logger.getLogger(GuestService.class);

    private IServiceDAO serviceDAO=(IServiceDAO) DependencyService.getDI().getInstance(IServiceDAO.class);

    public void addGuestService(Guest guest, Service service, int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month + 1, day);
        Date serviceDate = calendar.getTime();
        GuestServiceInfo guestServiceInfo = new GuestServiceInfo(guestServiceInfoCount, guest, service, serviceDate);
        synchronized (this.guestServiceDAO) {
            this.guestServiceDAO.addEntity(guestServiceInfo);
        }
        guestServiceInfoCount++;

    }

    public ArrayList<GuestServiceInfo> getAllGuestServicesInfo(Guest guest) {
        synchronized (this.guestServiceDAO) {
            ArrayList<GuestServiceInfo> allGuestServicesInfo = new ArrayList<GuestServiceInfo>();
            for (GuestServiceInfo guestServiceInfo : this.guestServiceDAO.getAllEntities()) {
                if (guestServiceInfo.getGuest().equals(guest)) {
                    allGuestServicesInfo.add(guestServiceInfo);
                }
            }
            return allGuestServicesInfo;
        }

    }

    public void addService(Service service) {
        synchronized (this.serviceDAO) {
           // this.serviceStorage.addEntity(service);
            serviceDAO.addEntity(service);
        }
    }

    public List<Service> getAllHotelServices() {
        synchronized (this.serviceDAO) {
            return this.serviceDAO.getAllEntities();
        }
    }
    public ArrayList<Service> getAllHotelServicesSortedByCost() {
        ArrayList<Service> allServices = new ArrayList<Service>(this.getAllHotelServices());
        allServices.sort(SERVICE_COST_COMPARATOR);
        return allServices;
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
}
