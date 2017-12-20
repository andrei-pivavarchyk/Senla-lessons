package com.dao;


import com.entity.Guest;
import com.entity.GuestRoomInfo;

import java.util.List;

/**
 * Created by андрей on 11.12.2017.
 */
public interface IGuestRoomInfoDAO extends IBaseDAO<GuestRoomInfo> {
    GuestRoomInfo getEntityByGuestId(int guestID);
    List<GuestRoomInfo> getCurrentGuestRoomInfo(Boolean isLiving, TypeSorting sorting);
    void removeEntityByGuestId(int guestID);
    void updateEntityStatus(Guest object, int status);
    Integer  getCountGuests(Boolean isliving);
    List<Guest> getGuestsByStatus(int status,int roomNumber,TypeSorting sorting);
    List<Guest> getLastGuestsInRoom( int roomNumber);
}
