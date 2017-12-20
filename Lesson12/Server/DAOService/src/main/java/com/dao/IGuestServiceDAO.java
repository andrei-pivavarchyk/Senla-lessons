package com.dao;


import com.entity.Guest;
import com.entity.GuestServiceInfo;

import java.util.List;

public interface IGuestServiceDAO extends IBaseDAO<GuestServiceInfo> {
    List<GuestServiceInfo> getAllEntitiesByGuest(Guest guest, TypeSorting sorting);
    void removeEntityByGuestId(Guest guest);
}
