package com.testHotel.service;


import com.entity.Guest;
import com.entity.GuestServiceInfo;
import com.entity.Service;

import java.util.List;

public interface IServiceService {
    void addGuestService(Guest guest, Service service, int year, int month, int day);
    List<GuestServiceInfo> getAllGuestServicesInfo(Guest guest);
    List<GuestServiceInfo> getAllGuestServicesInfoSortedByCost(Guest guest);
    List<GuestServiceInfo> getAllGuestServicesInfoSortedByDate(Guest guest);
    void addService(Service service);
    List<Service> getAllHotelServices();
    List<Service> getAllHotelServicesSortedByCost();


}
