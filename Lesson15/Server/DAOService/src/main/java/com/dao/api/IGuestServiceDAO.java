package com.dao.api;


import com.dao.TypeSorting;
import com.entity.Guest;
import com.entity.GuestServiceInfo;
import com.entity.Service;

import java.util.List;

public interface IGuestServiceDAO extends IBaseDAO<GuestServiceInfo> {
    List<Service> getAllGuestServices(Guest guest,TypeSorting typeSorting);
    List<GuestServiceInfo> getAllGuestServiceInfo(Guest guest, TypeSorting typeSorting);
    void deleteServicesByGuest(Guest guest);
}
