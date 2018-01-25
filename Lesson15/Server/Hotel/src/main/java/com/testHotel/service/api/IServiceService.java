package com.testHotel.service.api;

import com.dao.TypeSorting;
import com.entity.Guest;
import com.entity.GuestServiceInfo;
import com.entity.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public interface IServiceService {



    void addService(Service service);

    List<Service> getAllHotelServices(TypeSorting sorting);

    Service getServiceById(Integer id);

    void addHotelService(Service service);

    void updateService(Service service);

    void deleteService(Integer id);


    // GuestService

    List<GuestServiceInfo>  getAllGuestServiceInfo(TypeSorting sorting);
    List<GuestServiceInfo> getAllGuestServicesInfoByGuest(Guest guest,TypeSorting sorting);

    void addGuestService(Integer guestId, Integer serviceId, int year, int month, int day);

    void removeGuestServiceByGuest(Integer id);

    void updateGuestService(GuestServiceInfo guestServiceInfo);
    void addGuestServiceInfo(GuestServiceInfo guestServiceInfo);

}



