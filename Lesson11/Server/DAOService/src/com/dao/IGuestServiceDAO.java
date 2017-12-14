package com.dao;

import com.testHotel.entity.Guest;
import com.testHotel.entity.GuestServiceInfo;

import java.util.List;


public interface IGuestServiceDAO extends IBaseDAO<GuestServiceInfo> {
    List<GuestServiceInfo> getAllEntitiesByGuest(Guest guest, TypeSorting sorting);
    void removeEntityByGuestId(Guest guest);
}
