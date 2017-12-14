package com.testHotel.service;

import com.dao.IGuestDAO;
import com.dao.IRoomDAO;
import com.dao.TypeSorting;
import com.dependencyService.DependencyService;
import com.dao.IGuestRoomInfoDAO;
import com.testHotel.entity.Guest;
import com.testHotel.entity.GuestRoomInfo;
import org.apache.log4j.Logger;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GuestService implements IGuestService, Serializable {

    private IGuestRoomInfoDAO guestRoomInfoDAO = (IGuestRoomInfoDAO) DependencyService.getDI().getInstance(IGuestRoomInfoDAO.class);
    private IGuestDAO guestDAO = (IGuestDAO) DependencyService.getDI().getInstance(IGuestDAO.class);
    private IRoomDAO roomDAO = (IRoomDAO) DependencyService.getDI().getInstance(IRoomDAO.class);
    public Logger log = Logger.getLogger(GuestService.class);

    public List<Guest> getAllGuests() {
        synchronized (this.guestRoomInfoDAO) {
            List<Guest> allGuests = new ArrayList<Guest>();
            for (GuestRoomInfo guestRoomInfo : this.guestRoomInfoDAO.getCurrentGuestRoomInfo(true,TypeSorting.NO_SORTING)) {
                    allGuests.add(guestRoomInfo.getGuest());
            }
            return allGuests;
        }
    }

    public List<Guest> getAllGuestsSortedByDateDeparture() {
        synchronized (this.guestRoomInfoDAO) {
            List<GuestRoomInfo> guesInfoList = new ArrayList<GuestRoomInfo>(this.guestRoomInfoDAO.getAllEntities(TypeSorting.BY_DEPARTURE_DATE));
           List<Guest> guestList=new ArrayList<Guest>();
            for (GuestRoomInfo guestRoomInfo : guesInfoList) {
                guestList.add(guestRoomInfo.getGuest());
            }
            return guestList;
        }
    }

    public Integer getAllGuestsCount() {
        synchronized (this.guestDAO) {
            return this.guestDAO.getCountEntity();
        }
    }

    public Integer getPayAmount(Guest guest) {
        synchronized (this.guestRoomInfoDAO) {
                   GuestRoomInfo guestRoomInfo=this.guestRoomInfoDAO.getEntityByGuestId(guest.getId());
                   long diff = guestRoomInfo.getDepartureDate().getTime() - guestRoomInfo.getArrivalDate().getTime();
                   int allDaysLiving = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                   int payGuest = allDaysLiving * guestRoomInfo.getRoom().getCost();
                   return payGuest;
               }
    }

    public List<GuestRoomInfo> getCurrentGuestRoomInfo() {
        synchronized (this.guestRoomInfoDAO) {
            ArrayList<GuestRoomInfo> currentGuestRoomInfoList = new ArrayList<GuestRoomInfo>();
            this.guestRoomInfoDAO.getCurrentGuestRoomInfo(true,TypeSorting.NO_SORTING);
            return currentGuestRoomInfoList;
        }
    }

    public List<Guest> getAllGuestsSortedByName() {
        synchronized (this.guestDAO) {
            List<Guest> guestList=this.guestDAO.getAllEntities(TypeSorting.BY_NAME);
            return guestList;
        }
    }
}
