package com.dao;

import com.testHotel.entity.Room;
import com.testHotel.entity.RoomStatus;

import java.util.List;

public interface IRoomDAO extends IBaseDAO<Room> {
    List<Room> getAllEntitiesByStatus(RoomStatus status, TypeSorting sorting);
    Integer  getCountEntity();

}
