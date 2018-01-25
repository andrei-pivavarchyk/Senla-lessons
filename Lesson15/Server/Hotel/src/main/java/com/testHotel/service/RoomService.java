package com.testHotel.service;


import com.configurator.ConfigProperty;
import com.configurator.PropertyFilePath;
import com.configurator.PropertyName;
import com.dao.*;

import com.dao.api.IGuestDAO;
import com.dao.api.IGuestRoomInfoDAO;
import com.dao.api.IRoomDAO;
import com.dependencyService.DependencyService;
import com.entity.Guest;
import com.entity.GuestRoomInfo;
import com.entity.Room;
import com.entity.RoomStatus;
import com.testHotel.service.api.IRoomService;
import org.apache.log4j.Logger;
import org.hibernate.Transaction;

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
    private Factory factory;

    public void addRoom(Room room) {
        this.roomDAO.addEntity(room);
    }


    public List<Room> getAllRooms(TypeSorting sorting, RoomStatus status) {
        synchronized (this.roomDAO) {
            Transaction transaction = factory.getSession().beginTransaction();
            List<Room> freeRooms = this.roomDAO.getAllEntitiesByStatus(status, sorting);
            transaction.commit();
            return freeRooms;
        }
    }

    public Room getRoomByNumber(int roomNumber) {
        synchronized (this.roomDAO) {
            Transaction transaction = factory.getSession().beginTransaction();
            Room room = roomDAO.getEntityByNumber(roomNumber);
            transaction.commit();
            return room;
        }
    }

    public Room getRoomById(int roomNumber) {
        synchronized (this.roomDAO) {
            Transaction transaction = factory.getSession().beginTransaction();
            Room room = roomDAO.getEntityById(roomNumber);
            transaction.commit();
            return room;
        }
    }

    public void addGuest(int roomNumber, Guest guest, int year, int month, int day) {
        synchronized (this.guestRoomInfoDAO) {
            Transaction transaction = factory.getSession().beginTransaction();
            Room room = this.getRoomByNumber(roomNumber);
            if (room != null) {
                Date arrivalDate = DateUtil.getDate(year, month, day);
                GuestRoomInfo guestRoomInfo = new GuestRoomInfo(guest, room, new Date(), arrivalDate, true);
                this.guestRoomInfoDAO.addEntity(guestRoomInfo);
                transaction.commit();
            }
        }
    }

    public void addGuestRoomInfo(GuestRoomInfo guestRoomInfo) {
        Transaction transaction = factory.getSession().beginTransaction();
        this.guestRoomInfoDAO.addEntity(guestRoomInfo);
        transaction.commit();
    }


    public Long getCountOldRoomGuests(Room room) {
        synchronized (this.guestRoomInfoDAO) {
            Transaction transaction = factory.getSession().beginTransaction();
            Long count = guestRoomInfoDAO.getCountOldGuestsByRoom(room);
            transaction.commit();
            return count;
        }
    }

    public void departureGuest(Guest guest) {
        synchronized (this.guestRoomInfoDAO) {
            Transaction transaction = factory.getSession().beginTransaction();
            this.guestRoomInfoDAO.departureGuest(guest);
            transaction.commit();
        }
    }


    public Integer getFreeRoomsCount() {
        synchronized (this.roomDAO) {
            Transaction transaction = factory.getSession().beginTransaction();
            List<Room> freeRooms = this.roomDAO.getAllEntitiesByStatus(RoomStatus.FREE, TypeSorting.BY_COUNT);
            transaction.commit();
            return freeRooms.size();
        }
    }


    public void setRoomCost(int roomNumber, int cost) {
        synchronized (this.roomDAO) {
            Transaction transaction = factory.getSession().beginTransaction();
            Room room = this.roomDAO.getEntityById(roomNumber);
            room.setCost(cost);
            this.roomDAO.updateEntity(room);
            transaction.commit();
        }
    }

    public void importRooms(List<Room> importList) {
        synchronized (this.roomDAO) {
            Transaction transaction = factory.getSession().beginTransaction();
            for (Room room : importList) {
                this.roomDAO.addEntity(room);
            }
            transaction.commit();
        }
    }

    public void setRoomStatus(Room room, RoomStatus roomStatus) {
        if (this.chooseRoomStatus) {
            Transaction transaction = factory.getSession().beginTransaction();
            room.setStatus(roomStatus);
            this.roomDAO.updateEntity(room);
            transaction.commit();
        }
    }

    public List<GuestRoomInfo> getAllGuestRoomInfo(TypeSorting sorting) {
        Transaction transaction = factory.getSession().beginTransaction();
        List<GuestRoomInfo> list= this.guestRoomInfoDAO.getAllEntities(sorting);
        transaction.commit();
        return list;
    }

    public Integer getMaxCountOldGuests() {
        return maxCountOldGuests;
    }

    public void addEntity(Room entity) {
        this.roomDAO.addEntity(entity);
    }

    public void updateEntity(Room entity) {
        this.roomDAO.updateEntity(entity);
    }

    public void deleteEntity(Integer id) {
        this.roomDAO.deleteEntity(id);
    }

}




