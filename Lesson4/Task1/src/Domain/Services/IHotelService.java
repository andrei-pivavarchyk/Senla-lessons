package Domain.Services;

import Domain.Entities.Guest;
import Domain.Entities.Room;
import Sorting.RoomSortType;

import java.util.Date;

public interface IHotelService {
    void PrintRoomsSortedBy(RoomSortType roomSortType);

    void PrintFreeRoomsSortedBy(RoomSortType roomSortType);

    int getRoomsCount();

    int getFreeRoomsCount();

    int getGuestsCount();

    void addRoom(Room room);

    void removeRoom(Room room);

    void printFreeRoomsByDate(Date date);

    void addGuestToRoom(int roomNumber, Guest guest, int year, int month, int day);

    void getRoomDetails(Room room);
}
