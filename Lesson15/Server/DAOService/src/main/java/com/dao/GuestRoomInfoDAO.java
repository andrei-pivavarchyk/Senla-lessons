package com.dao;

import com.dependencyService.DependencyService;
import com.entity.*;
import org.hibernate.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GuestRoomInfoDAO extends BaseDAO<GuestRoomInfo> implements IGuestRoomInfoDAO{
    private IGuestDAO guestDAO = (IGuestDAO) DependencyService.getDI().getInstance(IGuestDAO.class);
    private IRoomDAO roomDAO = (IRoomDAO) DependencyService.getDI().getInstance(IRoomDAO.class);

public GuestRoomInfoDAO(){
    super("GuestRoomInfo");
}

    public void addGuest(GuestRoomInfo guestRoomInfo) {
        synchronized (this.guestDAO) {
            super.getSession().beginTransaction();
            guestDAO.addEntity(guestRoomInfo.getGuest());
            this.addEntity(guestRoomInfo);
            guestRoomInfo.getRoom().setStatus(RoomStatus.RESERVED);
            roomDAO.updateEntity(guestRoomInfo.getRoom());
            this.addEntity(guestRoomInfo);
            super.getSession().getTransaction().commit();
        }
    }

    public void departureGuest(Guest guest) {
        super.getSession().beginTransaction();
        Query createQuery = super.getSession().createQuery("from GuestRoomInfo where isStillLiving=true and guest=:param");
        createQuery.setParameter("param", guest);
        GuestRoomInfo guestRoomInfo=(GuestRoomInfo)createQuery.uniqueResult();
        guestRoomInfo.setIsstillliving(false);
        this.updateEntity(guestRoomInfo);
        super.getSession().getTransaction().commit();
    }


    public GuestRoomInfo getLastGuest(Room room){
        Query createQuery = super.getSession().createQuery("from GuestRoomInfo where room=:param and isStillLiving=false and departuredate=(select max(departuredate)  from GuestRoomInfo)");
        createQuery.setParameter("param", room);
        GuestRoomInfo gr =(GuestRoomInfo) createQuery.uniqueResult();
        super.getSession().getTransaction().commit();
        return gr;
    }

    public List<GuestRoomInfo> getGuestRoomInfoByGuest(Guest guest) {
        Query createQuery = super.getSession().createQuery("from GuestRoomInfo where guest=:param");
        createQuery.setParameter("param", guest);
        List<GuestRoomInfo> roomList = createQuery.list();
        super.getSession().getTransaction().commit();
        return roomList;
    }

    public List<GuestRoomInfo> getCurrentGuestRoomInfo(Boolean isLiving, TypeSorting sorting) {
        Query createQuery = super.getSession().createQuery("from GuestRoomInfo where isStillLiving=:param");
        createQuery.setParameter("param", isLiving);
        List<GuestRoomInfo> guestRoomInfoList = createQuery.list();
        super.getSession().getTransaction().commit();
        return guestRoomInfoList;
    }

    public void removeEntityByGuest(Guest guest) {

        super.getSession().beginTransaction();
        Query createQuery = super.getSession().createQuery(" delete GuestRoomInfo where guest =:param ");
        createQuery.setParameter("param", guest);
        createQuery.executeUpdate();
        super.getSession().getTransaction().commit();

    }

    public GuestRoomInfo getEntityByGuest(Guest guest) {
        super.getSession().beginTransaction();
        Query createQuery = super.getSession().createQuery(" from GuestRoomInfo where guest =:param ");
        createQuery.setParameter("param", guest);
        GuestRoomInfo gr= (GuestRoomInfo)createQuery.list().get(0);
        super.getSession().getTransaction().commit();
        return gr;
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

    public List<Guest> getGuestByStatus(RoomStatus status,TypeSorting sorting) {
        super.getSession().beginTransaction();
        Query createQuery = super.getSession().createQuery("select guest from GuestRoomInfo where isStillLiving=:param ");
        if (status.equals(RoomStatus.FREE)) {
            createQuery.setParameter("param", false);
        } else {
            createQuery.setParameter("param", true);
        }
        if(sorting.getType()!=TypeSorting.NO_SORTING.getType()){
            createQuery.getQueryString().concat(" order by" + sorting.getType());
        }

        createQuery.list();
        super.getSession().getTransaction().commit();
        return createQuery.list();
    }



    public Long getCountOldGuestsByRoom(Room room) {
        super.getSession().beginTransaction();
        Query createQuery = super.getSession().createQuery("select count(*) from GuestRoomInfo where isStillLiving =false and room=:param ");
        createQuery.setParameter("param", room);
        Long count = (Long) createQuery.uniqueResult();
        super.getSession().getTransaction().commit();
        return count;

    }

}
