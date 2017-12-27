package com.dao;

import com.entity.*;
import org.hibernate.Query;

import java.util.ArrayList;
import java.util.List;

public class GuestRoomHibernateDao extends BaseHibernateDao<GuestRoomInfo> {


    public List<Room> getGuestRoomInfoByGuest(Guest guest) {
        Query createQuery = super.getSession().createQuery("from GuestRoomInfo where guest=:param");
        createQuery.setParameter("param", guest);
        List<Room> roomList = createQuery.list();
        return roomList;
    }

    public List<GuestRoomInfo> getCurrentGuestRoomInfo(Boolean isLiving, TypeSorting sorting) {
        Query createQuery = super.getSession().createQuery("from GuestRoomInfo where isStillLiving=:param");
        createQuery.setParameter("param", isLiving);
        List<GuestRoomInfo> guestRoomInfoList = createQuery.list();
        return guestRoomInfoList;
    }

    public void removeEntityByGuest(Guest guest) {

        super.getSession().beginTransaction();
        Query createQuery = super.getSession().createQuery(" delete GuestRoomInfo where guest =:param ");
        createQuery.setParameter("param", guest);
        createQuery.executeUpdate();
        super.getSession().getTransaction().commit();

    }

    public void updateEntityStatus(Guest guest, RoomStatus status) {
        super.getSession().beginTransaction();
        Query createQuery = super.getSession().createQuery("update GuestRoomInfo set isStillLiving = :param");

        if (status.equals(RoomStatus.FREE)) {
            createQuery.setParameter("param", false);
        } else {
            createQuery.setParameter("param", true);
        }

        createQuery.executeUpdate();
        super.getSession().getTransaction().commit();
    }

    public Long getCountGuestsByStatus(RoomStatus status) {

        super.getSession().beginTransaction();
        Query createQuery = super.getSession().createQuery("select count(*) from GuestRoomInfo where isStillLiving =:param ");
        if (status.equals(RoomStatus.FREE)) {
            createQuery.setParameter("param", false);
        } else {
            createQuery.setParameter("param", true);
        }
        Long count = (Long) createQuery.uniqueResult();
        super.getSession().getTransaction().commit();
        return count;

    }

    public List<Guest> getGuestByStatus(RoomStatus status) {
        super.getSession().beginTransaction();
        Query createQuery = super.getSession().createQuery("select Guest from GuestRoomInfo inner join Guest where isStillLiving=:param");
        if (status.equals(RoomStatus.FREE)) {
            createQuery.setParameter("param", false);
        } else {
            createQuery.setParameter("param", true);
        }
        createQuery.list();
     // List<Guest> guestList=createQuery.list();
        super.getSession().getTransaction().commit();
        return null;
    }
}
