package com.testHotel.service;

import com.dao.*;


import com.dao.api.IGuestDAO;
import com.dao.api.IGuestRoomInfoDAO;
import com.dependencyService.DependencyService;
import com.entity.Guest;
import com.entity.GuestRoomInfo;
import com.entity.RoomStatus;
import com.testHotel.service.api.IGuestService;
import org.apache.log4j.Logger;
import org.hibernate.Transaction;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GuestService implements IGuestService, Serializable {

    private IGuestRoomInfoDAO guestRoomInfoDAO = (IGuestRoomInfoDAO) DependencyService.getDI().getInstance(IGuestRoomInfoDAO.class);
    private IGuestDAO guestDAO = (IGuestDAO) DependencyService.getDI().getInstance(IGuestDAO.class);
    public Logger log = Logger.getLogger(GuestService.class);
    private Factory factory;


    public List<Guest> getAllGuests(TypeSorting sorting) {
        synchronized (this.guestRoomInfoDAO) {
            Transaction transaction = factory.getSession().beginTransaction();
            List<Guest> allGuests = guestRoomInfoDAO.getGuestByStatus(RoomStatus.RESERVED, sorting);
            transaction.commit();
            return allGuests;
        }
    }

    public Long getAllGuestsCount() {
        synchronized (this.guestRoomInfoDAO) {
            Transaction transaction = factory.getSession().beginTransaction();
            Long count = guestRoomInfoDAO.getCountGuestsByStatus(RoomStatus.RESERVED);
            transaction.commit();
            return count;
        }
    }

    public Integer getPayAmount(Guest guest) {
        synchronized (this.guestRoomInfoDAO) {
            Transaction transaction = factory.getSession().beginTransaction();
            GuestRoomInfo guestRoomInfo = this.guestRoomInfoDAO.getEntityByGuest(guest);
            long diff = guestRoomInfo.getDeparturedate().getTime() - guestRoomInfo.getArrivaldate().getTime();
            int allDaysLiving = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            int payGuest = allDaysLiving * guestRoomInfo.getRoom().getCost();
            transaction.commit();
            return payGuest;
        }
    }

    public List<GuestRoomInfo> getCurrentGuestRoomInfo() {
        synchronized (this.guestRoomInfoDAO) {
            Transaction transaction = factory.getSession().beginTransaction();
            ArrayList<GuestRoomInfo> currentGuestRoomInfoList = new ArrayList<GuestRoomInfo>();
            this.guestRoomInfoDAO.getCurrentGuestRoomInfo(true, TypeSorting.NO_SORTING);
            transaction.commit();
            return currentGuestRoomInfoList;
        }
    }

    public Guest getGuestById(Integer id) {
        Transaction transaction = factory.getSession().beginTransaction();
        Guest guest = this.guestDAO.getEntityById(id);
        transaction.commit();
        return guest;
    }

    public void addGuest(Guest guest) {
        Transaction transaction = factory.getSession().beginTransaction();
        this.guestDAO.addEntity(guest);
        transaction.commit();
    }

    public void removeGuest(Integer id)

    {
        Transaction transaction = factory.getSession().beginTransaction();
        this.guestDAO.deleteEntity(id);
        transaction.commit();
    }

    public void updateGuest(Guest guest) {
        Transaction transaction = factory.getSession().beginTransaction();
        this.guestDAO.updateEntity(guest);
        transaction.commit();
    }
}
