package com.testHotel.service;


import com.configurator.ConfigProperty;
import com.configurator.PropertyFilePath;
import com.configurator.PropertyName;
import com.dao.*;

import com.dependencyService.DependencyService;
import com.entity.Guest;
import com.entity.GuestRoomInfo;
import com.entity.Room;
import com.entity.RoomStatus;
import org.apache.log4j.Logger;
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
            return this.roomDAO.getEntityByNumber(roomNumber);
        }
    }


    public void addGuest(int roomNumber, Guest guest, int year, int month, int day) {
        synchronized (this.guestRoomInfoDAO) {
            Room room = this.getRoomByNumber(roomNumber);
            if(room!=null){
                Date arrivalDate=DateUtil.getDate(year,month,day);
                GuestRoomInfo guestRoomInfo = new GuestRoomInfo(guest,room,new Date(),arrivalDate,true);
                this.guestRoomInfoDAO.addEntity(guestRoomInfo);
            }

            }
    }

    public Long getCountOldRoomGuests(Room room) {
        synchronized (this.guestRoomInfoDAO) {
            return   guestRoomInfoDAO.getCountOldGuestsByRoom(room);
        }

    }

    public void departureGuest(Guest guest) {
        synchronized (this.guestRoomInfoDAO) {
            this.guestRoomInfoDAO.departureGuest(guest);
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



    public void setRoomCost(int roomNumber, int cost) {
        synchronized (this.roomDAO) {
        Room room=this.roomDAO.getEntityById(roomNumber);
        room.setCost(cost);
        this.roomDAO.updateEntity(room);
        }
    }

    public void importRooms(List<Room> importList) {
        synchronized (this.roomDAO) {
            for (Room room : importList) {
                this.roomDAO.addEntity(room);
            }
        }
    }

    public void setRoomStatus(Room room,RoomStatus roomStatus) {
        if(this.chooseRoomStatus){
            room.setStatus(roomStatus);
            this.roomDAO.updateEntity(room);
        }
    }

    public Integer getMaxCountOldGuests() {
        return maxCountOldGuests;
    }
}




