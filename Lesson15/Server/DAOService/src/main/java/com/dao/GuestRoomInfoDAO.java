package com.dao;

import com.dependencyService.DependencyService;
import com.entity.*;
import org.apache.log4j.Logger;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class GuestRoomInfoDAO extends BaseDAO<GuestRoomInfo> implements IGuestRoomInfoDAO {
    private IGuestDAO guestDAO = (IGuestDAO) DependencyService.getDI().getInstance(IGuestDAO.class);
    private IRoomDAO roomDAO = (IRoomDAO) DependencyService.getDI().getInstance(IRoomDAO.class);

    public GuestRoomInfoDAO() {
        super("GuestRoomInfo", GuestRoomInfo.class);
    }

    public void addGuest(GuestRoomInfo guestRoomInfo) {
        synchronized (this.guestDAO) {
            getSession().save(guestRoomInfo.getGuest());
            getSession().save(guestRoomInfo);
            guestRoomInfo.getRoom().setStatus(RoomStatus.RESERVED);
            getSession().save(guestRoomInfo.getRoom());
        }
    }

    public void departureGuest(Guest guest) {
        GuestRoomInfo object = (GuestRoomInfo) getSession().createCriteria(GuestRoomInfo.class)
                .add(Restrictions.eq("guest", guest)).uniqueResult();
        object.setIsstillliving(false);
        this.updateEntity(object);

    }

    public GuestRoomInfo getLastGuest(Room room) {
        List<GuestRoomInfo> object = (List<GuestRoomInfo>) getSession().createCriteria(GuestRoomInfo.class)
                .add(Restrictions.eq("room", room))
                .add(Restrictions.eq("isstillliving", false))
                .addOrder(Order.desc("departuredate"))
                .list();
        return object.get(object.size() - 1);
    }

    public List<GuestRoomInfo> getGuestRoomInfoByGuest(Guest guest) {
        List<GuestRoomInfo> object = (List<GuestRoomInfo>) getSession().createCriteria(GuestRoomInfo.class)
                .add(Restrictions.eq("guest", guest))
                .add(Restrictions.eq("isstillliving", true))
                .list();
        return object;
    }

    public List<GuestRoomInfo> getCurrentGuestRoomInfo(Boolean isLiving, TypeSorting sorting) {
        List<GuestRoomInfo> object = (List<GuestRoomInfo>) getSession().createCriteria(GuestRoomInfo.class)
                .add(Restrictions.eq("isstillliving", true))
                .list();
        return object;
    }

    public void removeEntityByGuest(Guest guest) {
        GuestRoomInfo object = (GuestRoomInfo) getSession().createCriteria(GuestRoomInfo.class)
                .add(Restrictions.eq("guest", guest))
                .add(Restrictions.eq("isstillliving", true))
                .uniqueResult();
        getSession().delete(object);
    }

    public GuestRoomInfo getEntityByGuest(Guest guest) {
        GuestRoomInfo object = (GuestRoomInfo) super.getSession().createCriteria(GuestRoomInfo.class)
                .add(Restrictions.eq("guest", guest))
                .add(Restrictions.eq("isstillliving", true))
                .uniqueResult();
        return object;
    }


    public Long getCountGuestsByStatus(RoomStatus status) {
        Long count = (Long) super.getSession().createCriteria(GuestRoomInfo.class)
                .add(Restrictions.eq("isstillliving", true))
                .setProjection(Projections.rowCount())
                .uniqueResult();
        return count;
    }

    public List<Guest> getGuestByStatus(RoomStatus status, TypeSorting sorting) {
        Boolean roomStatus;
        if (status.equals(RoomStatus.FREE)) {
            roomStatus = false;
        } else {
            roomStatus = true;
        }
        List<Guest> object = (List<Guest>) super.getSession().createCriteria(GuestRoomInfo.class)
                .add(Restrictions.eq("isstillliving", roomStatus))
                .list();
        return object;
    }


    public Long getCountOldGuestsByRoom(Room room) {
        Transaction transaction = getSession().beginTransaction();
        Long count = (Long) super.getSession().createCriteria(GuestRoomInfo.class)
                .add(Restrictions.eq("isstillliving", false))
                .add(Restrictions.eq("room", room))
                .setProjection(Projections.rowCount()).uniqueResult();
        transaction.commit();
        return count;
    }
}
