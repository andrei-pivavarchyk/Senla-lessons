package com.dao;

import com.entity.*;
import org.hibernate.Query;

import java.util.ArrayList;
import java.util.List;

public class GuestRoomHibernateDao extends BaseHibernateDao<GuestRoomInfo> {


    public List<Room> getGuestRoomInfoByGuest(Guest guest){
        Query createQuery = super.getSession().createQuery("from GuestRoomInfo where guest=:param");
        createQuery.setParameter("param", guest);
        List <Room> roomList = createQuery.list();
        return roomList;
    }

    public List<GuestRoomInfo> getCurrentGuestRoomInfo(Boolean isLiving, TypeSorting sorting){
        Query createQuery = super.getSession().createQuery("from GuestRoomInfo where isStillLiving=:param");
        createQuery.setParameter("param", isLiving);
        List <GuestRoomInfo> guestRoomInfoList = createQuery.list();
        return guestRoomInfoList;
    }

    public void removeEntityByGuest(){




    }

}
