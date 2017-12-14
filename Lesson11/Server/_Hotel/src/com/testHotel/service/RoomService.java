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

import java.util.*;


public class RoomService implements IRoomService {

    private IRoomDAO roomDAO = (IRoomDAO) DependencyService.getDI().getInstance(IRoomDAO.class);
    private IGuestServiceDAO guestServiceDAO = (IGuestServiceDAO) DependencyService.getDI().getInstance(IGuestServiceDAO.class);
    private IGuestRoomInfoDAO guestRoomInfoDAO = (IGuestRoomInfoDAO) DependencyService.getDI().getInstance(IGuestRoomInfoDAO.class);
    private IGuestDAO guestDAO = (IGuestDAO) DependencyService.getDI().getInstance(IGuestDAO.class);

    private int guestRoomInfoCount = 0;
    private static final Comparator<Room> COST_COMPARATOR = new RoomCostComparator();
    private static final Comparator<Room> CAPACITY_COMPARATOR = new RoomCapacityComparator();
    private static final Comparator<Room> STARS_COMPARATOR = new RoomStarsComparator();
    private static final Comparator<Room> ID_COMPARATOR = new RoomIdComparator();
    @ConfigProperty(configPath = PropertyFilePath.CONFIG_HOTEL_PROPERTIES, propertyName = PropertyName.MAX_NUMBER_OF_LAST_ROOM_GUESTS)
    private Integer maxCountOldGuests;
    @ConfigProperty(configPath = PropertyFilePath.CONFIG_HOTEL_PROPERTIES, propertyName = PropertyName.CHOOSE_ROOM_STATUS)
    private Boolean chooseRoomStatus;
    public static final Logger log = Logger.getLogger(RoomService.class);

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
            List<Room> copyArray = this.roomDAO.getAllEntities(TypeSorting.BY_COST);
            return copyArray;
        }
    }

    public List<Room> getRoomCapacitySorting() {

        synchronized (this.roomDAO) {
            List<Room> copyArray = this.roomDAO.getAllEntities(TypeSorting.BY_CAPACITY);
            return copyArray;
        }

    }

    public List<Room> getRoomStarsSorting() {
        synchronized (this.roomDAO) {
            List<Room> copyArray = this.roomDAO.getAllEntities(TypeSorting.BY_STARS);
            return copyArray;
        }
    }

    public Room getRoomByNumber(int roomNumber) {
        synchronized (this.roomDAO) {
            Room room = this.roomDAO.getEntity(roomNumber);
            return room;
        }
    }


    public void addGuest(int roomNumber, Guest guest, int year, int month, int day) {
        synchronized (this.guestRoomInfoDAO) {
            synchronized (this.guestRoomInfoDAO) {
                Room room = this.getRoomByNumber(roomNumber);
                GuestRoomInfo guestRoomInfo = new GuestRoomInfo(new Date(), guest, room, year, month, day);
                this.guestDAO.addEntity(guest);
                this.guestRoomInfoDAO.addEntity(guestRoomInfo);
            }
        }
    }

    public int getCountOldRoomGuests(Room room) {
        synchronized (this.guestRoomInfoDAO) {
            int count = 0;
            for (GuestRoomInfo info : this.guestRoomInfoDAO.getCurrentGuestRoomInfo(false, TypeSorting.NO_SORTING)) {
                count++;
            }
            return count;
        }
    }

    public void departureGuest(Guest guest) {
        synchronized (this.guestRoomInfoDAO) {
            synchronized (this.guestServiceDAO) {
                this.guestServiceDAO.removeEntityByGuestId(guest);
                this.guestRoomInfoDAO.updateEntityStatus(guest, 0);
            }
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
            int count = 0;
            for (Room room : this.roomDAO.getAllEntities(TypeSorting.NO_SORTING)) {
                if (room.getStatus().equals(RoomStatus.FREE)) {
                    count++;
                }
            }
            return count;
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
            Room room = this.roomDAO.getEntity(roomNumber);
            room.setCost(cost);
            this.roomDAO.updateEntity(room);
        }
    }



    public Room cloneRoom(Room room) throws CloneNotSupportedException {
        Room clone = room.clone();
        synchronized (this.roomDAO) {
            clone.setId(this.roomDAO.getCountEntity() + 1);
            return clone;
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




