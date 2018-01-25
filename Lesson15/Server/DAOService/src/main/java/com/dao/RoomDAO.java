package com.dao;


import com.dao.api.IRoomDAO;
import com.entity.Room;
import com.entity.RoomStatus;
import org.hibernate.Query;

import java.util.List;

public class RoomDAO extends BaseDAO<Room> implements IRoomDAO {
    public RoomDAO() {
        super("Room", Room.class);
    }

    public List<Room> getAllEntitiesByStatus(RoomStatus status, TypeSorting sorting) {
        Query createQuery = super.getSession().createQuery(" from Room where status =:param ");
        if (sorting.getType() != TypeSorting.NO_SORTING.getType()) {
            String query = createQuery.getQueryString();
            query = query.concat("order by :type");
            createQuery.setParameter("type", sorting.getType());
        }
        createQuery.setParameter("param", status);
        List<Room> roomList = createQuery.list();
        return roomList;
    }


    public Long getCountAllRoom(RoomStatus status) {
        Query createQuery = super.getSession().createQuery("select count(*) from Room where status =:param ");
        createQuery.setParameter("param", status);
        Long count = (Long) createQuery.uniqueResult();
        return count;
    }

    public Room getEntityByNumber(Integer number) {
        Query createQuery = super.getSession().createQuery(" from Room where number =:param ");
        createQuery.setParameter("param", number);
        List<Room> roomList = createQuery.list();
        return roomList.get(0);
    }
}
