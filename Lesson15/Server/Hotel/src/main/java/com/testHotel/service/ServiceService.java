package com.testHotel.service;

import com.dao.*;

import com.dao.api.IGuestDAO;
import com.dao.api.IGuestServiceDAO;
import com.dao.api.IServiceDAO;
import com.dependencyService.DependencyService;
import com.entity.Guest;
import com.entity.GuestServiceInfo;
import com.entity.Service;
import com.testHotel.service.api.IServiceService;
import org.apache.log4j.Logger;
import org.hibernate.Transaction;

import java.util.*;

public class ServiceService implements IServiceService {

    public static final Logger log = Logger.getLogger(GuestService.class);
    private IServiceDAO serviceDAO = (IServiceDAO) DependencyService.getDI().getInstance(IServiceDAO.class);
    private IGuestDAO guestDAO = (IGuestDAO) DependencyService.getDI().getInstance(IGuestDAO.class);
    private IGuestServiceDAO guestServiceDAO = (IGuestServiceDAO) DependencyService.getDI().getInstance(IGuestServiceDAO.class);
    private Factory factory;

    public void addService(Service service) {
        synchronized (this.serviceDAO) {
            Transaction transaction = factory.getSession().beginTransaction();
            serviceDAO.addEntity(service);
            transaction.commit();
        }
    }

    public List<Service> getAllHotelServices(TypeSorting sorting) {
        synchronized (this.serviceDAO) {
            Transaction transaction = factory.getSession().beginTransaction();
            List<Service> list = serviceDAO.getAllEntities(sorting);
            transaction.commit();
            return list;
        }
    }


    public Service getServiceById(Integer id) {
        Transaction transaction = factory.getSession().beginTransaction();
        Service service = serviceDAO.getEntityById(id);
        transaction.commit();
        return service;
    }

    public void addHotelService(Service service) {
        this.serviceDAO.addEntity(service);
    }

    public void updateService(Service service) {
        Transaction transaction = factory.getSession().beginTransaction();
        this.serviceDAO.updateEntity(service);
        transaction.commit();
    }

    public void deleteService(Integer id) {
        Transaction transaction = factory.getSession().beginTransaction();
        this.serviceDAO.deleteEntity(id);
        transaction.commit();
    }

    public List<GuestServiceInfo> getAllGuestServiceInfo(TypeSorting sorting) {
        Transaction transaction = factory.getSession().beginTransaction();
        List<GuestServiceInfo> list = this.guestServiceDAO.getAllEntities(sorting);
        transaction.commit();
        return list;
    }

    public List<GuestServiceInfo> getAllGuestServicesInfoByGuest(Guest guest, TypeSorting sorting) {
        synchronized (this.guestServiceDAO) {
            Transaction transaction = factory.getSession().beginTransaction();
            List<GuestServiceInfo> allGuestServicesInfo = this.guestServiceDAO.getAllGuestServiceInfo(guest, sorting);
            transaction.commit();
            return allGuestServicesInfo;
        }

    }

    public void addGuestService(Integer guestId, Integer serviceId, int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        Date serviceDate = calendar.getTime();
        Guest guest = this.guestDAO.getEntityById(guestId);
        Service service = this.serviceDAO.getEntityById(serviceId);
        GuestServiceInfo guestServiceInfo = new GuestServiceInfo(guest, service, serviceDate);
        synchronized (this.guestServiceDAO) {
            Transaction transaction = factory.getSession().beginTransaction();
            this.guestServiceDAO.addEntity(guestServiceInfo);
            transaction.commit();
        }
    }

    public void addGuestServiceInfo(GuestServiceInfo guestServiceInfo) {
        synchronized (this.guestServiceDAO) {
            Transaction transaction = factory.getSession().beginTransaction();
            this.guestServiceDAO.addEntity(guestServiceInfo);
            transaction.commit();
        }
    }

    public void removeGuestServiceByGuest(Integer id) {
        Transaction transaction = factory.getSession().beginTransaction();
        Guest guest = this.guestDAO.getEntityById(id);
        this.guestServiceDAO.deleteServicesByGuest(guest);
        transaction.commit();
    }

    public void updateGuestService(GuestServiceInfo guestServiceInfo) {
        Transaction transaction = factory.getSession().beginTransaction();
        this.guestServiceDAO.updateEntity(guestServiceInfo);
        transaction.commit();
    }

}
