package main.java.com.testHotel.service;


import com.testHotel.entity.Guest;
import com.testHotel.entity.Service;
import com.testHotel.entity.GuestServiceInfo;
import com.testHotel.storage.IGuestServiceStorage;
import com.testHotel.storage.IServiceStorage;

import java.sql.Connection;
import java.util.ArrayList;
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
