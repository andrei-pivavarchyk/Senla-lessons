package com.testHotel.service;


import com.configurator.ConfigProperty;
import com.configurator.PropertyFilePath;
import com.configurator.PropertyName;
import com.dependencyService.DependencyService;
import com.testHotel.comparator.RoomCapacityComparator;
import com.testHotel.comparator.RoomCostComparator;
import com.testHotel.comparator.RoomIdComparator;
import com.testHotel.comparator.RoomStarsComparator;
import com.testHotel.dao.IGuestDAO;
import com.testHotel.dao.IRoomDAO;
import com.testHotel.entity.Guest;
import com.testHotel.entity.Room;
import com.testHotel.storage.IGuestRoomInfoStorage;
import com.testHotel.entity.GuestRoomInfo;
import com.testHotel.entity.RoomStatus;
import org.apache.log4j.Logger;

import java.util.*;


public class RoomService implements IRoomService {

    private IRoomDAO roomDAO = (IRoomDAO) DependencyService.getDI().getInstance(IRoomDAO.class);
    private IGuestRoomInfoStorage guestRoomInfoStorage = (IGuestRoomInfoStorage) DependencyService.getDI().getInstance(IGuestRoomInfoStorage.class);

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
            return this.roomDAO.getAllEntities();
        }
    }

    public ArrayList<Room> getRoomCostSorting() {
        synchronized (this.roomDAO) {
            ArrayList<Room> copyArray = this.getArrayRoomCostSorting((ArrayList<Room>) this.roomDAO.getAllEntities());
            return copyArray;
        }
    }

    public ArrayList<Room> getRoomCapacitySorting() {

        synchronized (this.roomDAO) {
            ArrayList<Room> copyArray = this.getArrayRoomCapacitySorting((ArrayList<Room>) this.roomDAO.getAllEntities());
            return copyArray;
        }

    }

    public ArrayList<Room> getRoomStarsSorting() {
        synchronized (this.roomDAO) {
            ArrayList<Room> copyArray = this.getArrayRoomStarsSorting((ArrayList<Room>) this.roomDAO.getAllEntities());
            return copyArray;
        }
    }

    public Room getRoomByNumber(int roomNumber) {
        synchronized (this.roomDAO) {
            for (Room room : this.roomDAO.getAllEntities()) {
                if (room.getNumber() == roomNumber) {
                    return room;
                }
            }
            return null;
        }
    }

    public Room getRoomById(int roomId) {
        synchronized (this.roomDAO) {
            for (Room room : this.roomDAO.getAllEntities()) {
                if (room.getId() == roomId) {
                    return room;
                }
            }
            return null;
        }
    }

    public void addGuest(int roomNumber, Guest guest, int year, int month, int day) {

        Room room = this.getRoomByNumber(roomNumber);
        if (room != null) {
            if (this.chooseRoomStatus.equals(true)) {
                room.setStatus(RoomStatus.RESERVED);
            }
            room.getGuests().add(guest);
            Calendar calendar = Calendar.getInstance();
            Date arrivalDate = calendar.getTime();
            GuestRoomInfo guestRoomInfo = new GuestRoomInfo(this.guestRoomInfoCount, arrivalDate, guest, room, year, month, day);

            this.guestRoomInfoCount++;
            synchronized (this.guestRoomInfoStorage) {
                if (this.getCountOldGuests(room) == this.maxCountOldGuests) {
                    this.guestRoomInfoStorage.getAllEntities().remove(0);
                }
                this.guestRoomInfoStorage.addEntity(guestRoomInfo);

                this.guestDAO.addEntity(guest);
            }
        } else {
            log.error("No room with that number");
        }

    }


    private int getCountOldGuests(Room room) {
        synchronized (this.guestRoomInfoStorage) {
            int count = 0;
            for (GuestRoomInfo info : this.guestRoomInfoStorage.getAllEntities()) {
                if (info.getRoom().equals(room)) {
                    count++;
                }
            }
            return count;
        }
    }

    public void departureGuest(Guest guest) {
        synchronized (this.guestRoomInfoStorage) {
            List<GuestRoomInfo> allGuestRoomInfo = this.guestRoomInfoStorage.getAllEntities();
            for (GuestRoomInfo guestRoomInfo : allGuestRoomInfo) {
                if (guestRoomInfo.getGuest().equals(guest)) {
                    guestRoomInfo.setStillLiving(false);
                    guestRoomInfo.setDepartureDate(new Date());
                }
            }
        }
    }

    public ArrayList<Room> getFreeRooms() {

        synchronized (this.roomDAO) {
            ArrayList<Room> freeRooms = new ArrayList<Room>();
            for (Room room : this.roomDAO.getAllEntities()) {
                if (room.getStatus().equals(RoomStatus.FREE)) {
                    freeRooms.add(room);
                }
            }
            return freeRooms;

        }
    }

    public void printFreeRoomsCount() {
        synchronized (this.roomDAO) {
            int count = 0;
            for (Room room : this.roomDAO.getAllEntities()) {
                if (room.getStatus().equals(RoomStatus.FREE)) {
                    count++;
                }
            }
        }
    }

    public ArrayList<Room> getFreeRoomsByDate(int year, int month, int day) {
        ArrayList<Room> freeRoomsByDate = this.getFreeRooms();
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        synchronized (this.guestRoomInfoStorage) {
            for (GuestRoomInfo guestRoomInfo : this.guestRoomInfoStorage.getAllEntities()) {
                if (guestRoomInfo.getDepartureDate().compareTo(calendar.getTime()) == -1) {
                    freeRoomsByDate.add(guestRoomInfo.getRoom());
                }
            }
        }

        return freeRoomsByDate;
    }

    public ArrayList<GuestRoomInfo> getThreeLastGuests(int roomNumber) {

        ArrayList<GuestRoomInfo> guestRoomInfoList = new ArrayList<GuestRoomInfo>();

        Room room = this.getRoomByNumber(roomNumber);

        for (int i = room.getGuests().size(), k = 0; i > 0 && k < 3; i--, k++) {
            Guest guest = room.getGuests().get(i - 1);
            synchronized (this.guestRoomInfoStorage) {
                for (GuestRoomInfo guestRoomInfo : this.guestRoomInfoStorage.getAllEntities()) {
                    if (guestRoomInfo.getGuest().equals(guest)) {
                        guestRoomInfoList.add(guestRoomInfo);
                    }
                }
            }
        }

        return guestRoomInfoList;
    }

    public void setRoomCost(int roomNumber, int cost) {
        Room room = this.getRoomByNumber(roomNumber);
        room.setCost(cost);
    }

    public ArrayList<Room> getArrayRoomCostSorting(ArrayList<Room> allRooms) {

        allRooms.sort(COST_COMPARATOR);
        return allRooms;
    }

    public ArrayList<Room> getArrayRoomCapacitySorting(ArrayList<Room> allRooms) {

        allRooms.sort(CAPACITY_COMPARATOR);
        return allRooms;
    }

    public ArrayList<Room> getArrayRoomStarsSorting(ArrayList<Room> allRooms) {

        allRooms.sort(STARS_COMPARATOR);
        return allRooms;
    }

    public Room cloneRoom(Room room) throws CloneNotSupportedException {
        Room clone = room.clone();

        synchronized (this.roomDAO) {
            int roomId = this.roomDAO.getAllEntities().size();
            clone.setId(roomId);
            return clone;
        }
    }

    public void glueTwoArrays(List<Room> importList) {
        List<Room> currentRoomList = this.getAllRooms();
        for (Room importRoom : importList) {
            int importRoomID = importRoom.getId();
            Room checkingRoom = this.getRoomById(importRoomID);

            if (checkingRoom == null) {
                currentRoomList.add(importRoom);
            } else {
                currentRoomList.remove(checkingRoom);
                currentRoomList.add(importRoom);
            }
        }
        currentRoomList.sort(ID_COMPARATOR);
    }

    public void setGuestRoomInfoStorage(IGuestRoomInfoStorage guestRoomInfoStorage) {
        this.guestRoomInfoStorage = guestRoomInfoStorage;
    }
}




