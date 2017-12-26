package com.dao;

import com.entity.GuestServiceInfo;
import com.entity.Room;
import com.entity.RoomStatus;
import org.hibernate.Query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoomHibernateDao extends BaseHibernateDao<Room> {
    public List<Room> getAllEntitiesByStatus(RoomStatus status, TypeSorting sorting) {
        super.getSession().beginTransaction();
        Query createQuery = super.getSession().createQuery(" from Room where status =:param ");
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

}
