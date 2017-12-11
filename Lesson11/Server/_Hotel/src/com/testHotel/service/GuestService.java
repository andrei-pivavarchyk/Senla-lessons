package com.testHotel.service;

import com.dependencyService.DependencyService;
import com.testHotel.comparator.GuestNameComparator;
import com.testHotel.comparator.GuestRoomInfoDateComparator;
import com.dao.IGuestRoomInfoDAO;
import com.testHotel.entity.Guest;
import com.testHotel.entity.GuestRoomInfo;
import org.apache.log4j.Logger;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class GuestService implements IGuestService, Serializable {

    private IGuestRoomInfoDAO guestRoomInfoDAO = (IGuestRoomInfoDAO) DependencyService.getDI().getInstance(IGuestRoomInfoDAO.class);
    private static final Comparator<Guest> NAME_COMPARATOR = new GuestNameComparator();
    private static final Comparator<GuestRoomInfo> DATE_COMPARATOR = new GuestRoomInfoDateComparator();
    public Logger log = Logger.getLogger(GuestService.class);




    public ArrayList<Guest> getAllGuests() {
        synchronized (this.guestRoomInfoDAO) {
            ArrayList<Guest> allGuests = new ArrayList<Guest>();
            for (GuestRoomInfo guestRoomInfo : this.guestRoomInfoDAO.getAllEntities()) {
                if (guestRoomInfo.getStillLiving().equals(true)) {
                    allGuests.add(guestRoomInfo.getGuest());
                }
            }
            return allGuests;
        }
    }

    public ArrayList<Guest> getAllGuestsSortedByDateDeparture() {
        synchronized (this.guestRoomInfoDAO) {
            ArrayList<GuestRoomInfo> copyArray = new ArrayList<GuestRoomInfo>(this.guestRoomInfoDAO.getAllEntities());
            ArrayList<Guest> guestList = new ArrayList<Guest>();
            copyArray.sort(DATE_COMPARATOR);
            for (GuestRoomInfo guestRoomInfo : copyArray) {
                guestList.add(guestRoomInfo.getGuest());
            }
            return guestList;
        }
    }

    public void printAllGuestsCount() {
        synchronized (this.guestRoomInfoDAO) {
            int count = 0;
            for (GuestRoomInfo guestRoomInfo : this.guestRoomInfoDAO.getAllEntities()) {
                if (guestRoomInfo.getStillLiving().equals(true)) {
                    count++;
                }
            }
        }

    }

    public int getPayAmount(Guest guest) {
        synchronized (this.guestRoomInfoDAO) {
            int payGuest = 0;
            for (GuestRoomInfo guestRoomInfo : this.guestRoomInfoDAO.getAllEntities()) {
                if (guestRoomInfo.getGuest().equals(guest)) {
                    Date date1 = guestRoomInfo.getArrivalDate();
                    Date date2 = guestRoomInfo.getDepartureDate();
                    long diff = date2.getTime() - date1.getTime();
                    int allDaysLiving = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                    payGuest = allDaysLiving * guestRoomInfo.getRoom().getCost();


                }
            }
            return payGuest;
        }
    }

    public ArrayList<GuestRoomInfo> getCurrentGuestRoomInfo() {
        synchronized (this.guestRoomInfoDAO) {
            ArrayList<GuestRoomInfo> currentGuestRoomInfoList = new ArrayList<GuestRoomInfo>();
            for (GuestRoomInfo guestRoomInfo : this.guestRoomInfoDAO.getAllEntities()) {
                if (guestRoomInfo.getStillLiving().equals(true)) {
                    currentGuestRoomInfoList.add(guestRoomInfo);
                }
            }
            return currentGuestRoomInfoList;
        }
    }
    public ArrayList<Guest> getAllGuestsSortedByName() {
        ArrayList<Guest> copyArray = new ArrayList<Guest>(this.getAllGuests());
        copyArray.sort(NAME_COMPARATOR);
        return copyArray;
    }

}
