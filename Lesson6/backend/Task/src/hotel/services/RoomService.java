package hotel.services;

import com.sun.istack.internal.logging.Logger;
import property.EnumProperty;
import property.IProperty;
import property.Proops;
import hotel.storage.IGuestRoomInfoStorage;
import hotel.storage.IGuestStorage;
import hotel.storage.IRoomStorage;
import hotel.comparator.*;
import hotel.entity.Guest;
import hotel.entity.GuestRoomInfo;
import hotel.entity.Room;
import hotel.entity.RoomStatus;

import java.io.Serializable;
import java.util.*;


public class RoomService implements IRoomService,Serializable {

    private IRoomStorage roomStorage;
    private IGuestRoomInfoStorage guestRoomInfoStorage;
    private IGuestStorage guestStorage;
    private int guestRoomInfoCount = 0;
    private final Comparator<Room> COST_COMPARATOR = new RoomCostComparator();
    private final Comparator<Room> CAPACITY_COMPARATOR = new RoomCapacityComparator();
    private final Comparator<Room> STARS_COMPARATOR = new RoomStarsComparator();
    private Integer maxCountOldGuests;
    private IProperty property;
    public static final Logger log= Logger.getLogger(GuestService.class);


    public RoomService(IRoomStorage roomStorage, IGuestRoomInfoStorage guestRoomInfoStorage, IGuestStorage guestStorage, IProperty property) {
        this.roomStorage = roomStorage;
        this.guestRoomInfoStorage = guestRoomInfoStorage;
        this.guestStorage = guestStorage;
        this.property=property;
        this.maxCountOldGuests = Integer.valueOf(property.getProperty(EnumProperty.MAX_NUMBER_OF_LAST_ROOM_GUESTS));
        log.info("Room service started");

    }

    public void addRoom(Room room) {
        this.roomStorage.addEntity(room);
    }

    public List<Room> getAllRooms() {

        return this.roomStorage.getAllEntities();

    }

    public ArrayList<Room> getRoomCostSorting() {
        ArrayList<Room> copyArray = this.getArrayRoomCostSorting((ArrayList<Room>) this.roomStorage.getAllEntities());
        return copyArray;
    }

    public ArrayList<Room> getRoomCapacitySorting() {
        ArrayList<Room> copyArray = this.getArrayRoomCapacitySorting((ArrayList<Room>) this.roomStorage.getAllEntities());
        return copyArray;
    }

    public ArrayList<Room> getRoomStarsSorting() {
        ArrayList<Room> copyArray = this.getArrayRoomStarsSorting((ArrayList<Room>) this.roomStorage.getAllEntities());
        return copyArray;
    }

    public Room getRoomByNumber(int roomNumber) {
        for (Room room : this.roomStorage.getAllEntities()) {
            if (room.getNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    public void addGuest(int roomNumber, Guest guest, int year, int month, int day, Boolean chooseRoomStatus) {

        Room room = this.getRoomByNumber(roomNumber);
        if (room != null) {
            if (chooseRoomStatus.equals(true)) {
                room.setStatus(RoomStatus.RESERVED);
            }

            room.getGuests().add(guest);
            Calendar calendar = Calendar.getInstance();
            Date arrivalDate = calendar.getTime();
            GuestRoomInfo guestRoomInfo = new GuestRoomInfo(this.guestRoomInfoCount, arrivalDate, guest, room, year, month, day);

            this.guestRoomInfoCount++;

            if (this.getCountOldGuests(room) == this.maxCountOldGuests) {
                this.guestRoomInfoStorage.getAllEntities().remove(0);
            }
            this.guestRoomInfoStorage.addEntity(guestRoomInfo);

            this.guestStorage.addEntity(guest);

        } else {
            System.out.println("There is no room with this number");
        }

    }


    private int getCountOldGuests(Room room) {

        int count = 0;
        for (GuestRoomInfo info : this.guestRoomInfoStorage.getAllEntities()) {
            if (info.getRoom().equals(room)) {
                count++;
            }
        }
        return count;
    }

    public void departureGuest(Guest guest) {

        List<GuestRoomInfo> allGuestRoomInfo = this.guestRoomInfoStorage.getAllEntities();
        for (GuestRoomInfo guestRoomInfo : allGuestRoomInfo) {
            if (guestRoomInfo.getGuest().equals(guest)) {
                guestRoomInfo.setStillLiving(false);
                guestRoomInfo.setDepartureDate(new Date());
            }
        }

    }

    public ArrayList<Room> getFreeRooms() {
        ArrayList<Room> freeRooms = new ArrayList<Room>();
        for (Room room : this.roomStorage.getAllEntities()) {
            if (room.getStatus().equals(RoomStatus.FREE)) {
                freeRooms.add(room);
            }
        }
        return freeRooms;
    }

    public void printFreeRoomsCount() {
        int count = 0;
        for (Room room : this.roomStorage.getAllEntities()) {
            if (room.getStatus().equals(RoomStatus.FREE)) {
                count++;
            }
        }
        System.out.println(new StringBuilder("All free rooms count:").append(count));
    }

    public ArrayList<Room> getFreeRoomsByDate(int year, int month, int day) {
        ArrayList<Room> freeRoomsByDate = this.getFreeRooms();
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        for (GuestRoomInfo guestRoomInfo : this.guestRoomInfoStorage.getAllEntities()) {
            if (guestRoomInfo.getDepartureDate().compareTo(calendar.getTime()) == -1) {
                freeRoomsByDate.add(guestRoomInfo.getRoom());
            }
        }

        return freeRoomsByDate;
    }

    public ArrayList<GuestRoomInfo> getThreeLastGuests(int roomNumber) {

        ArrayList<GuestRoomInfo> guestRoomInfoList = new ArrayList<GuestRoomInfo>();

        Room room = this.getRoomByNumber(roomNumber);

        for (int i = room.getGuests().size(), k = 0; i > 0 && k < 3; i--, k++) {
            Guest guest = room.getGuests().get(i - 1);

            for (GuestRoomInfo guestRoomInfo : this.guestRoomInfoStorage.getAllEntities()) {
                if (guestRoomInfo.getGuest().equals(guest)) {
                    guestRoomInfoList.add(guestRoomInfo);
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
          return clone;
    }
}




