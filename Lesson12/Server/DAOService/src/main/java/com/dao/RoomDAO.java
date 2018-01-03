package com.dao;


import com.entity.Room;
import com.entity.RoomStatus;
import org.hibernate.Query;

import java.util.List;

public class RoomDAO extends BaseDAO<Room> implements IRoomDAO{
    public RoomDAO(){
        super("Room");
    }

    public List<Room> getAllEntitiesByStatus(RoomStatus status, TypeSorting sorting) {
        super.getSession().beginTransaction();
        Query createQuery = super.getSession().createQuery(" from Room where status =:param ");
        if(sorting.getType()!=TypeSorting.NO_SORTING.getType()){
            String query=createQuery.getQueryString();
            query= query.concat("order by :type");
            createQuery.setParameter("type", sorting.getType());
        }
        createQuery.setParameter("param",status);
        List <Room> roomList=createQuery.list();
        super.getSession().getTransaction().commit();
        return roomList;
    }


    public Long getCountAllRoom(RoomStatus status) {
        super.getSession().beginTransaction();
        Query createQuery = super.getSession().createQuery("select count(*) from Room where status =:param ");
        createQuery.setParameter("param",status);
        Long count = (Long)createQuery.uniqueResult();
        super.getSession().getTransaction().commit();
        return count;
    }

    public Room getEntityByNumber(Integer number) {
        super.getSession().beginTransaction();
        Query createQuery = super.getSession().createQuery(" from Room where number =:param ");
        createQuery.setParameter("param",number);
        List <Room> roomList=createQuery.list();
        super.getSession().getTransaction().commit();
        return roomList.get(0);
    }

}
