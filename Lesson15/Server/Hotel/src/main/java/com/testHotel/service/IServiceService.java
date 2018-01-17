package com.testHotel.service;

import com.dao.TypeSorting;
import com.entity.Guest;
import com.entity.GuestServiceInfo;
import com.entity.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public interface IServiceService {

    List<GuestServiceInfo> getAllGuestServicesInfo(Guest guest, TypeSorting sorting);

    void addService(Service service);

    List<Service> getAllHotelServices(TypeSorting sorting);

    Service getServiceById(Integer id);

    void addHotelService(Service service);

    void updateService(Service service);

    void deleteService(Integer id);


    // GuestService

    List<GuestServiceInfo>  getAllGuestServiceInfo(Integer id,TypeSorting sorting);

    void addGuestService(Integer guestId, Integer serviceId, int year, int month, int day);

    void removeGuestServiceByGuest(Integer id);

    void updateGuestService(GuestServiceInfo guestServiceInfo);
    void addGuestServiceInfo(GuestServiceInfo guestServiceInfo);

}



