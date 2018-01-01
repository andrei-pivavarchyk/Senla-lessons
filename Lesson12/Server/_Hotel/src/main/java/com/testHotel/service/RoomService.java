package main.java.com.testHotel.service;


import com.configurator.ConfigProperty;
import com.configurator.PropertyFilePath;
import com.configurator.PropertyName;
import com.dao.*;
import com.dependencyService.DependencyService;
import com.testHotel.entity.Guest;
import com.testHotel.entity.Room;
import com.testHotel.entity.GuestRoomInfo;
import com.testHotel.entity.RoomStatus;
import com.testHotel.service.IRoomService;
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

    @Override
    public Room cloneRoom(Room room) throws CloneNotSupportedException {
        return null;
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

    @Override
    public List<Room> getFreeRoomsByDate(int i, int i1, int i2) {
        return null;
    }

    @Override
    public List<GuestRoomInfo> getThreeLastGuests(int i) {
        return null;
    }

    public List<Guest> getLastGuests(int roomNumber) {
        List<Guest> someLastGuests=new ArrayList<>(this.maxCountOldGuests);
      List<Guest> guestList= this.guestRoomInfoDAO.getLastGuestsInRoom(roomNumber);
      for(int i=0;i<maxCountOldGuests;i++){
          someLastGuests.add(guestList.get(i));
      }
        return someLastGuests;
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

    public void setRoomStatus(Room room,RoomStatus roomStatus) {
        if(this.chooseRoomStatus){
            room.setStatus(roomStatus);
            this.roomDAO.updateEntity(room);
        }
    }
}




