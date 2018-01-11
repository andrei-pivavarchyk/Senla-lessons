package com.testHotel.service;

import com.dao.*;


import com.dependencyService.DependencyService;
import com.entity.Guest;
import com.entity.GuestRoomInfo;
import com.entity.RoomStatus;
import org.apache.log4j.Logger;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GuestService implements IGuestService, Serializable {

    private IGuestRoomInfoDAO guestRoomInfoDAO = (IGuestRoomInfoDAO) DependencyService.getDI().getInstance(IGuestRoomInfoDAO.class);
    private IGuestDAO guestDAO = (IGuestDAO) DependencyService.getDI().getInstance(IGuestDAO.class);
    public Logger log = Logger.getLogger(GuestService.class);


    public List<Guest> getAllGuests() {
        synchronized (this.guestRoomInfoDAO) {
            List<Guest> allGuests = guestRoomInfoDAO.getGuestByStatus(RoomStatus.RESERVED, TypeSorting.NO_SORTING);
            return allGuests;
        }
    }

    public List<Guest> getAllGuestsSortedByDateDeparture() {
        synchronized (this.guestRoomInfoDAO) {
            List<Guest> allGuests = guestRoomInfoDAO.getGuestByStatus(RoomStatus.RESERVED, TypeSorting.BY_DEPARTURE_DATE);
            return allGuests;
        }
    }

    public List<Guest> getAllGuestsSortedByName() {
        synchronized (this.guestRoomInfoDAO) {
            List<Guest> allGuests = guestRoomInfoDAO.getGuestByStatus(RoomStatus.RESERVED, TypeSorting.BY_NAME);
            return allGuests;
        }
    }

    public Long getAllGuestsCount() {
        synchronized (this.guestRoomInfoDAO) {
            Long count = guestRoomInfoDAO.getCountGuestsByStatus(RoomStatus.RESERVED);
            return count;
        }
    }

    public Integer getPayAmount(Guest guest) {
        synchronized (this.guestRoomInfoDAO) {
            GuestRoomInfo guestRoomInfo = this.guestRoomInfoDAO.getEntityByGuest(guest);
            long diff = guestRoomInfo.getDeparturedate().getTime() - guestRoomInfo.getArrivaldate().getTime();
            int allDaysLiving = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            int payGuest = allDaysLiving * guestRoomInfo.getRoom().getCost();
            return payGuest;
        }
    }

    public List<GuestRoomInfo> getCurrentGuestRoomInfo() {
        synchronized (this.guestRoomInfoDAO) {
            ArrayList<GuestRoomInfo> currentGuestRoomInfoList = new ArrayList<GuestRoomInfo>();
            this.guestRoomInfoDAO.getCurrentGuestRoomInfo(true, TypeSorting.NO_SORTING);
            return currentGuestRoomInfoList;
        }
    }

    public Guest getGuestById(Integer id) {
        return this.guestDAO.getEntityById(id);
    }

    public void addGuest(Guest guest) {
        this.guestDAO.addEntity(guest);
    }

    public void removeGuest(Guest guest) {
        this.guestDAO.deleteEntity(guest);
    }

    public void updateGuest(Guest guest) {
        this.guestDAO.updateEntity(guest);
    }
}
