package com.testHotel.service;

import com.dao.TypeSorting;
import com.dependencyService.DependencyService;
import com.dao.IGuestServiceDAO;
import com.dao.IServiceDAO;
import com.testHotel.entity.Guest;
import com.testHotel.entity.GuestServiceInfo;
import com.testHotel.entity.Service;
import org.apache.log4j.Logger;

import java.util.*;

public class ServiceService implements IServiceService {

    private IGuestServiceDAO guestServiceDAO = (IGuestServiceDAO) DependencyService.getDI().getInstance(IGuestServiceDAO.class);
    public static final Logger log = Logger.getLogger(GuestService.class);
    private IServiceDAO serviceDAO = (IServiceDAO) DependencyService.getDI().getInstance(IServiceDAO.class);

    public void addGuestService(Guest guest, Service service, int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        Date serviceDate = calendar.getTime();
        GuestServiceInfo guestServiceInfo = new GuestServiceInfo(1, guest, service, serviceDate);
        synchronized (this.guestServiceDAO) {
            this.guestServiceDAO.addEntity(guestServiceInfo);
        }
    }

    public List<GuestServiceInfo> getAllGuestServicesInfo(Guest guest) {
        synchronized (this.guestServiceDAO) {
            List<GuestServiceInfo> allGuestServicesInfo = this.guestServiceDAO.getAllEntitiesByGuest(guest, TypeSorting.NO_SORTING);
            return allGuestServicesInfo;
        }

    }

    public void addService(Service service) {
        synchronized (this.serviceDAO) {
            serviceDAO.addEntity(service);
        }
    }

    public List<Service> getAllHotelServices() {
        synchronized (this.serviceDAO) {
            return this.serviceDAO.getAllEntities(TypeSorting.NO_SORTING);
        }
    }

    public List<Service> getAllHotelServicesSortedByCost() {
        synchronized (this.serviceDAO) {
            return this.serviceDAO.getAllEntities(TypeSorting.BY_COST);
        }
    }

    public List<GuestServiceInfo> getAllGuestServicesInfoSortedByCost(Guest guest) {
        synchronized (this.guestServiceDAO) {
            return this.guestServiceDAO.getAllEntitiesByGuest(guest, TypeSorting.BY_COST);
        }
    }

    public List<GuestServiceInfo> getAllGuestServicesInfoSortedByDate(Guest guest) {
        synchronized (this.guestServiceDAO) {
            return this.guestServiceDAO.getAllEntitiesByGuest(guest, TypeSorting.BY_DATE);
        }
    }
}
