package com.dao;

import com.testHotel.entity.GuestRoomInfo;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by андрей on 11.12.2017.
 */
public interface IGuestRoomInfoDAO extends IBaseDAO<GuestRoomInfo> {
    GuestRoomInfo getEntityByGuestId(int guestID);
    List<GuestRoomInfo> getCurrentGuestRoomInfo(Boolean isLiving);
    void removeEntityByGuestId(int guestID);

}
