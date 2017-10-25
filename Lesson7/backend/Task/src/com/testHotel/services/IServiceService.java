package com.testHotel.services;


import com.testHotel.entity.Guest;
import com.testHotel.entity.Service;
import com.testHotel.entity.GuestServiceInfo;

import java.util.ArrayList;
import java.util.List;

public interface IServiceService {
    void addGuestService(Guest guest, Service service, int year, int month, int day);
    ArrayList<GuestServiceInfo> getAllGuestServicesInfo(Guest guest);
    ArrayList<GuestServiceInfo> getAllGuestServicesInfoSortedByCost(Guest guest);
    ArrayList<GuestServiceInfo> getAllGuestServicesInfoSortedByDate(Guest guest);
    void addService(Service service);
    List<Service> getAllHotelServices();
    ArrayList<Service> getAllHotelServicesSortedByCost();
}
