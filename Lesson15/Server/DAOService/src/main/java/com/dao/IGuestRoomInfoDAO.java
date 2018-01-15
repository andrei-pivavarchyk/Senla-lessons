package com.dao;


import com.entity.Guest;
import com.entity.GuestRoomInfo;
import com.entity.Room;
import com.entity.RoomStatus;

import java.util.List;


public interface IGuestRoomInfoDAO extends IBaseDAO<GuestRoomInfo> {
    List<GuestRoomInfo> getGuestRoomInfoByGuest(Guest guest);
    List<GuestRoomInfo> getCurrentGuestRoomInfo(Boolean isLiving, TypeSorting sorting);
    void removeEntityByGuest(Guest guest);

    Long getCountGuestsByStatus(RoomStatus status);
    List<Guest> getGuestByStatus(RoomStatus status,TypeSorting sorting);
    GuestRoomInfo getEntityByGuest(Guest guest);
    void addGuest(GuestRoomInfo guestRoomInfo);
    Long getCountOldGuestsByRoom(Room room);
    GuestRoomInfo getLastGuest(Room room);
    void departureGuest(Guest guest);
}
