package com.dao;


import com.entity.Guest;
import com.entity.GuestServiceInfo;
import com.entity.Service;

import java.util.List;

public interface IGuestServiceDAO extends IBaseDAO<GuestServiceInfo> {
    List<Service> getAllGuestServices(Guest guest,TypeSorting typeSorting);
    List<GuestServiceInfo> getAllGuestServiceInfo(Guest guest, TypeSorting typeSorting);
}
