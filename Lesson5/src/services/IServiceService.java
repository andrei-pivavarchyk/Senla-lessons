package services;


import Storage.IServiceStorage;
import entity.Guest;
import entity.GuestServiceInfo;
import entity.Service;

import java.util.ArrayList;

public interface IServiceService {
    void addGuestService(Guest guest, Service service, int year, int month, int day);
    ArrayList<GuestServiceInfo> getAllGuestServicesInfo(Guest guest);
    ArrayList<GuestServiceInfo> getAllGuestServicesInfoSortedByCost(Guest guest);
    ArrayList<GuestServiceInfo> getAllGuestServicesInfoSortedByDate(Guest guest);
    void addService(Service service);
    public IServiceStorage getServiceStorage();
    ArrayList<Service> getAllServicesSortedByCost();
}
