package com.testHotel.service;

import com.dao.TypeSorting;
import com.entity.Guest;
import com.entity.GuestRoomInfo;
import com.entity.Room;
import com.entity.RoomStatus;

import java.util.List;

public interface IRoomService {

    void addRoom(Room room);

    List<Room> getAllRooms(TypeSorting sorting, RoomStatus status);

    void addGuest(int roomNumber, Guest guest, int year, int month, int day);

    void departureGuest(Guest guest);
    void addGuestRoomInfo(GuestRoomInfo guestRoomInfo);
    List<GuestRoomInfo> getAllGuestRoomInfo(TypeSorting sorting);

    Integer getFreeRoomsCount();

    Room getRoomById(int roomNumber);

    void setRoomCost(int roomNumber, int cost);

    Room getRoomByNumber(int roomNumber);

    void importRooms(List<Room> importList);

    void setRoomStatus(Room room, RoomStatus roomStatus);

    Integer getMaxCountOldGuests();

    public void addEntity(Room entity);

    public void updateEntity(Room entity);

    public void deleteEntity(Integer id);
}
