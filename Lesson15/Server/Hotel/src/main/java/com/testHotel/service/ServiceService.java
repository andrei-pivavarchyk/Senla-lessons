package com.testHotel.service;

import com.dao.IGuestDAO;
import com.dao.TypeSorting;

import com.dao.IGuestServiceDAO;
import com.dao.IServiceDAO;
import com.dependencyService.DependencyService;
import com.entity.Guest;
import com.entity.GuestServiceInfo;
import com.entity.Service;
import org.apache.log4j.Logger;

import java.util.*;

public class ServiceService implements IServiceService {

    public static final Logger log = Logger.getLogger(GuestService.class);
    private IServiceDAO serviceDAO = (IServiceDAO) DependencyService.getDI().getInstance(IServiceDAO.class);
    private IGuestDAO guestDAO = (IGuestDAO) DependencyService.getDI().getInstance(IGuestDAO.class);
    private IGuestServiceDAO guestServiceDAO = (IGuestServiceDAO) DependencyService.getDI().getInstance(IGuestServiceDAO.class);

    public void addService(Service service) {
        synchronized (this.serviceDAO) {
            serviceDAO.addEntity(service);
        }
    }

    public List<Service> getAllHotelServices(TypeSorting sorting) {
        synchronized (this.serviceDAO) {
            return this.serviceDAO.getAllEntities(sorting);
        }
    }


    public Service getServiceById(Integer id) {
        return this.serviceDAO.getEntityById(id);
    }

    public void addHotelService(Service service) {
        this.serviceDAO.addEntity(service);
    }

    public void updateService(Service service) {
        this.serviceDAO.updateEntity(service);
    }

    public void deleteService(Integer id) {
        this.serviceDAO.deleteEntity(id);
    }

    //GuestService
    public List<GuestServiceInfo>  getAllGuestServiceInfo(TypeSorting sorting) {
        return this.guestServiceDAO.getAllEntities(sorting);
    }
    public List<GuestServiceInfo> getAllGuestServicesInfoByGuest(Guest guest,TypeSorting sorting) {
        synchronized (this.guestServiceDAO) {
            List<GuestServiceInfo> allGuestServicesInfo = this.guestServiceDAO.getAllGuestServiceInfo(guest, sorting);
            return allGuestServicesInfo;
        }

    }

    public void addGuestService(Integer guestId, Integer serviceId, int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        Date serviceDate = calendar.getTime();
        Guest guest=this.guestDAO.getEntityById(guestId);
        Service service=this.serviceDAO.getEntityById(serviceId);
        GuestServiceInfo guestServiceInfo = new GuestServiceInfo(guest, service, serviceDate);
        synchronized (this.guestServiceDAO) {
            this.guestServiceDAO.addEntity(guestServiceInfo);
        }
    }
    public void addGuestServiceInfo(GuestServiceInfo guestServiceInfo) {
        synchronized (this.guestServiceDAO) {
            this.guestServiceDAO.addEntity(guestServiceInfo);
        }
    }

    public void removeGuestServiceByGuest(Integer id) {
        Guest guest=this.guestDAO.getEntityById(id);
        this.guestServiceDAO.deleteServicesByGuest(guest);
    }

    public void updateGuestService(GuestServiceInfo guestServiceInfo) {
        this.guestServiceDAO.updateEntity(guestServiceInfo);
    }

}
