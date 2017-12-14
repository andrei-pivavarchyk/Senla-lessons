package com.dao.serviceDAO;

import com.dao.*;
import com.dependencyService.DependencyService;
import com.testHotel.entity.*;
import com.testHotel.service.GuestService;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ControllerDAO {
    private IGuestRoomInfoDAO guestRoomInfoDAO = (IGuestRoomInfoDAO) DependencyService.getDI().getInstance(IGuestRoomInfoDAO.class);
    private IGuestDAO guestDAO = (IGuestDAO) DependencyService.getDI().getInstance(IGuestDAO.class);
    private IRoomDAO roomDAO = (IRoomDAO) DependencyService.getDI().getInstance(IRoomDAO.class);
    private IServiceDAO serviceDAO = (IServiceDAO) DependencyService.getDI().getInstance(IServiceDAO.class);
    private IGuestServiceDAO guestServiceDAO = (IGuestServiceDAO) DependencyService.getDI().getInstance(IServiceDAO.class);
    public Logger log = Logger.getLogger(GuestService.class);
    private Connection con = ConnectionUtil.getConnectionUtil().getConnection();


    //START GUEST SERVICE
    public List<Guest> getAllGuests() {
        synchronized (this.guestRoomInfoDAO) {
            List<Guest> allGuests = new ArrayList<Guest>();
            for (GuestRoomInfo guestRoomInfo : this.guestRoomInfoDAO.getCurrentGuestRoomInfo(true, TypeSorting.NO_SORTING)) {
                allGuests.add(guestRoomInfo.getGuest());
            }
            return allGuests;
        }
    }

    public List<Guest> getAllGuestsSortedByDateDeparture() {
        synchronized (this.guestRoomInfoDAO) {
            List<GuestRoomInfo> guesInfoList = new ArrayList<GuestRoomInfo>(this.guestRoomInfoDAO.getCurrentGuestRoomInfo(true, TypeSorting.BY_DEPARTURE_DATE));
            List<Guest> guestList = new ArrayList<Guest>();
            for (GuestRoomInfo guestRoomInfo : guesInfoList) {
                guestList.add(guestRoomInfo.getGuest());
            }
            return guestList;
        }
    }

    public Integer getAllGuestsCount() {
        synchronized (this.guestRoomInfoDAO) {
            return this.guestRoomInfoDAO.getCountGuests(true);
        }
    }

    public Integer getPayAmount(Guest guest) {
        synchronized (this.guestRoomInfoDAO) {
            GuestRoomInfo guestRoomInfo = this.guestRoomInfoDAO.getEntityByGuestId(guest.getId());
            long diff = guestRoomInfo.getDepartureDate().getTime() - guestRoomInfo.getArrivalDate().getTime();
            int allDaysLiving = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            int payGuest = allDaysLiving * guestRoomInfo.getRoom().getCost();
            return payGuest;
        }
    }

    public List<GuestRoomInfo> getCurrentGuestRoomInfo() {
        synchronized (this.guestRoomInfoDAO) {

            return this.guestRoomInfoDAO.getCurrentGuestRoomInfo(true, TypeSorting.NO_SORTING);

        }
    }

    public List<Guest> getAllGuestsSortedByName() {
        synchronized (this.guestRoomInfoDAO) {
            return this.guestRoomInfoDAO.getGuestsByStatus(1,0, TypeSorting.BY_NAME);
        }
    }

    // ROOM SERVICE
    public void addRoom(Room room) {
        this.roomDAO.addEntity(room);
    }

    public List<Room> getAllRooms() {
        synchronized (this.roomDAO) {
            return this.roomDAO.getAllEntities(TypeSorting.NO_SORTING);
        }
    }


    public List<Room> getRoomCostSorting() {
        synchronized (this.roomDAO) {
            return this.roomDAO.getAllEntities(TypeSorting.BY_COST);

        }
    }

    public List<Room> getRoomCapacitySorting() {

        synchronized (this.roomDAO) {
            return this.roomDAO.getAllEntities(TypeSorting.BY_CAPACITY);

        }

    }

    public List<Room> getRoomStarsSorting() {
        synchronized (this.roomDAO) {
            return this.roomDAO.getAllEntities(TypeSorting.BY_STARS);

        }
    }

    public Room getRoomByNumber(int roomNumber) {
        synchronized (this.roomDAO) {
            return this.roomDAO.getEntity(roomNumber);
        }
    }


    public void addGuest(int roomNumber, Guest guest, int year, int month, int day)  {

        synchronized (this.guestRoomInfoDAO) {


                Room room = this.getRoomByNumber(roomNumber);
                GuestRoomInfo guestRoomInfo = new GuestRoomInfo(new Date(), guest, room, year, month, day);
                try {
                    this.con.setAutoCommit(false);
                    this.guestDAO.addEntity(guest);
                    this.guestRoomInfoDAO.addEntity(guestRoomInfo);
                   con.commit();
                   con.setAutoCommit(true);
            }catch (SQLException e) {

                    try {
                        con.rollback();
                    } catch (SQLException e1) {
                        log.error(e.toString());
                    }
                    log.error(e.toString());
                }
        }
    }

    public int getCountOldRoomGuests(Room room) {
        synchronized (this.guestRoomInfoDAO) {
            int count = 0;
            for (Guest info : this.guestRoomInfoDAO.getGuestsByStatus(0,room.getNumber(), TypeSorting.NO_SORTING)) {
                count++;
            }
            return count;
        }
    }

    public void departureGuest(Guest guest) {
        synchronized (this.guestRoomInfoDAO) {
                this.guestRoomInfoDAO.updateEntityStatus(guest, 0);
        }
    }

    public List<Room> getFreeRooms() {
        synchronized (this.roomDAO) {
            List<Room> freeRooms = this.roomDAO.getAllEntitiesByStatus(RoomStatus.FREE, TypeSorting.NO_SORTING);
            return freeRooms;
        }
    }

    public List<Room> getFreeRoomsCount() {
        synchronized (this.roomDAO) {
            List<Room> freeRooms = this.roomDAO.getAllEntitiesByStatus(RoomStatus.FREE, TypeSorting.BY_COUNT);
            return freeRooms;
        }
    }

    public List<Room> getFreeRoomsByDate(int year, int month, int day) {
      /*  ArrayList<Room> freeRoomsByDate = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        synchronized (this.guestRoomInfoDAO) {
            for (GuestRoomInfo guestRoomInfo : this.guestRoomInfoDAO.getAllEntities(TypeSorting.NO_SORTING)) {
                if (guestRoomInfo.getDepartureDate().compareTo(calendar.getTime()) == -1) {
                    freeRoomsByDate.add(guestRoomInfo.getRoom());
                }
            }
        }

        return freeRoomsByDate;*/
        return null;
    }

    public List<GuestRoomInfo> getThreeLastGuests(int roomNumber) {
/*
        ArrayList<GuestRoomInfo> guestRoomInfoList = new ArrayList<GuestRoomInfo>();

        Room room = this.getRoomByNumber(roomNumber);

        for (int i = room.getGuests().size(), k = 0; i > 0 && k < 3; i--, k++) {
            Guest guest = room.getGuests().get(i - 1);
            synchronized (this.guestRoomInfoDAO) {
                for (GuestRoomInfo guestRoomInfo : this.guestRoomInfoDAO.getAllEntities(TypeSorting.NO_SORTING)) {
                    if (guestRoomInfo.getGuest().equals(guest)) {
                        guestRoomInfoList.add(guestRoomInfo);
                    }
                }
            }
        }

        return guestRoomInfoList;
        */
        return null;
    }

    public void setRoomCost(int roomNumber, int cost) {
        synchronized (this.roomDAO) {
            try {
                con.setAutoCommit(false);
                Room room = this.roomDAO.getEntity(roomNumber);
                room.setCost(cost);
                this.roomDAO.updateEntity(room);
            } catch (SQLException e) {
                try {
                    con.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                log.error(e.toString());
            }

        }
    }


    public void importRooms(List<Room> importList) {
        synchronized (this.roomDAO) {
            for (Room room : importList) {
                this.roomDAO.addEntity(room);

            }
        }
    }

    //END ROOM SERVICE
    //SERVICE SERVICE
    public void addGuestService(Guest guest, Service service, int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        Date serviceDate = calendar.getTime();
        GuestServiceInfo guestServiceInfo = new GuestServiceInfo(1, guest, service, serviceDate);
        synchronized (this.guestServiceDAO) {
            this.guestServiceDAO.addEntity(guestServiceInfo);
        }
    }

    public List<GuestServiceInfo> getAllGuestServicesInfo(Guest guest) {
        synchronized (this.guestServiceDAO) {
            List<GuestServiceInfo> allGuestServicesInfo = this.guestServiceDAO.getAllEntitiesByGuest(guest,TypeSorting.NO_SORTING);
            return allGuestServicesInfo;
        }

    }

    public void addService(Service service) {
        synchronized (this.serviceDAO) {
            serviceDAO.addEntity(service);
        }
    }

    public List<Service> getAllHotelServices() {
        synchronized (this.serviceDAO) {
            return this.serviceDAO.getAllEntities(TypeSorting.NO_SORTING);
        }
    }

    public List<Service> getAllHotelServicesSortedByCost() {
        synchronized (this.serviceDAO) {
            return this.serviceDAO.getAllEntities(TypeSorting.BY_COST);
        }
    }

    public List<GuestServiceInfo> getAllGuestServicesInfoSortedByCost(Guest guest) {
        synchronized (this.guestServiceDAO) {
            return this.guestServiceDAO.getAllEntitiesByGuest(guest, TypeSorting.BY_COST);
        }
    }

    public List<GuestServiceInfo> getAllGuestServicesInfoSortedByDate(Guest guest) {
        synchronized (this.guestServiceDAO) {
            return this.guestServiceDAO.getAllEntitiesByGuest(guest, TypeSorting.BY_DATE);
        }
    }
}
