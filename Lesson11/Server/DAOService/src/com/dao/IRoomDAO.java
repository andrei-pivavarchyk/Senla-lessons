package com.dao;

import com.testHotel.entity.Room;
import com.testHotel.entity.RoomStatus;

import java.util.List;

/**
 * Created by андрей on 11.12.2017.
 */
public interface IRoomDAO extends IBaseDAO<Room> {
    List<Room> getAllEntitiesByStatus(RoomStatus status, TypeSorting sorting);
}
