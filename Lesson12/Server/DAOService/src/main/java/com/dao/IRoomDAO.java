package com.dao;


import com.entity.Room;
import com.entity.RoomStatus;

import java.util.List;

public interface IRoomDAO extends IBaseDAO<Room> {
    List<Room> getAllEntitiesByStatus(RoomStatus status, TypeSorting sorting);
    Room getEntityByNumber(Integer number);
}
