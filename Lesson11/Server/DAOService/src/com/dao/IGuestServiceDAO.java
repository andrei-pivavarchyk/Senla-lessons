package com.dao;

import com.testHotel.entity.Guest;
import com.testHotel.entity.GuestServiceInfo;

import java.util.List;

/**
 * Created by андрей on 11.12.2017.
 */
public interface IGuestServiceDAO extends IBaseDAO<GuestServiceInfo> {
    List<GuestServiceInfo> getAllEntitiesByGuest(Guest guest, TypeSorting sorting);
}
