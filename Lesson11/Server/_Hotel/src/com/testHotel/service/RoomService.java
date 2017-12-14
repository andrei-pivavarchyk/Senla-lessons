package com.testHotel.service;


import com.configurator.ConfigProperty;
import com.configurator.PropertyFilePath;
import com.configurator.PropertyName;
import com.dao.*;
import com.dependencyService.DependencyService;
import com.testHotel.entity.Guest;
import com.testHotel.entity.Room;
import com.testHotel.entity.GuestRoomInfo;
import com.testHotel.entity.RoomStatus;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;


public class RoomService implements IRoomService {

    private IGuestRoomInfoDAO guestRoomInfoDAO = (IGuestRoomInfoDAO) DependencyService.getDI().getInstance(IGuestRoomInfoDAO.class);
    private IRoomDAO roomDAO = (IRoomDAO) DependencyService.getDI().getInstance(IRoomDAO.class);
    private IGuestDAO guestDAO = (IGuestDAO) DependencyService.getDI().getInstance(IGuestDAO.class);

    @ConfigProperty(configPath = PropertyFilePath.CONFIG_HOTEL_PROPERTIES, propertyName = PropertyName.MAX_NUMBER_OF_LAST_ROOM_GUESTS)
    private Integer maxCountOldGuests;
    @ConfigProperty(configPath = PropertyFilePath.CONFIG_HOTEL_PROPERTIES, propertyName = PropertyName.CHOOSE_ROOM_STATUS)
    private Boolean chooseRoomStatus;
    public static final Logger log = Logger.getLogger(RoomService.class);
    private Connection con = ConnectionUtil.getConnectionUtil().getConnection();

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


    public void addGuest(int roomNumber, Guest guest, int year, int month, int day) {

        synchronized (this.guestRoomInfoDAO) {


            Room room = this.getRoomByNumber(roomNumber);
            GuestRoomInfo guestRoomInfo = new GuestRoomInfo(new Date(), guest, room, year, month, day);
            try {
                this.con.setAutoCommit(false);
                this.guestDAO.addEntity(guest);
                this.guestRoomInfoDAO.addEntity(guestRoomInfo);
                con.commit();
                con.setAutoCommit(true);
            } catch (SQLException e) {

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
            for (Guest info : this.guestRoomInfoDAO.getGuestsByStatus(0, room.getNumber(), TypeSorting.NO_SORTING)) {
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

    public Integer getFreeRoomsCount() {
        synchronized (this.roomDAO) {
            List<Room> freeRooms = this.roomDAO.getAllEntitiesByStatus(RoomStatus.FREE, TypeSorting.BY_COUNT);
            return freeRooms.size();
        }
    }

    public List<Room> getFreeRoomsByDate(int year, int month, int day) {
        List<Room> roomList = new ArrayList<>();

        List<GuestRoomInfo> guestRoomInfoList = this.guestRoomInfoDAO.getCurrentGuestRoomInfo(true, TypeSorting.NO_SORTING);
        List<Room> allRoomList = this.roomDAO.getAllEntities(TypeSorting.NO_SORTING);

        HashSet<Room> roomSet = new HashSet<Room>();

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

}




