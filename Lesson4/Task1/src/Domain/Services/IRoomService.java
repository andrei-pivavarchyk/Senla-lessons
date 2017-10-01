package Domain.Services;

import Domain.Entities.Room;
import Sorting.RoomSortType;

import java.util.ArrayList;

public interface IRoomService {
    void addRoom(Room room);

    void addRooms(ArrayList<Room> rooms);

    void removeRoom(Room room);

    ArrayList<Room> getFreeRooms();

    void printRoomsSortedBy(RoomSortType roomSortType);

    void printFreeRoomsSortedBy(RoomSortType roomSortType);

    int getFreeRoomsCount();

    void getRoomDetailsById(int roomId);
}
