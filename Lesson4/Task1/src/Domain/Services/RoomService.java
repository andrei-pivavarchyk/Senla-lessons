package Domain.Services;

import Domain.Contracts.IGuestRoomInfoRepository;
import Domain.Contracts.IRoomRepository;
import Domain.Entities.Room;
import Domain.Entities.RoomStatus;
import Sorting.RoomSortType;
import Utility.Literals;
import Utility.PrintOperationsService;

import java.util.ArrayList;

public class RoomService implements IRoomService {
    private IGuestRoomInfoRepository guestRoomInfoRepository;
    private IRoomRepository roomRepository;

    public RoomService(IGuestRoomInfoRepository guestRoomInfoRepository, IRoomRepository roomRepository) {
        this.guestRoomInfoRepository = guestRoomInfoRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public void addRoom(Room room) {
        roomRepository.Create(room);
    }

    @Override
    public void addRooms(ArrayList<Room> rooms) {
        roomRepository.BulkCreate(rooms);
    }

    @Override
    public void removeRoom(Room room) {
        roomRepository.Delete(room.id);
    }

    @Override
    public void printRoomsSortedBy(RoomSortType roomSortType) {
        PrintOperationsService.PrintRooms(PrintOperationsService.SortRoomsBy(roomRepository.Fetch(), roomSortType),
                "Rooms sorted by " + roomSortType.toString() + ":");
    }

    @Override
    public void printFreeRoomsSortedBy(RoomSortType roomSortType) {
        PrintOperationsService.PrintRooms(PrintOperationsService.SortRoomsBy(getFreeRooms(), roomSortType),
                "Rooms sorted by " + roomSortType.toString() + ":");
    }

    @Override
    public int getFreeRoomsCount() {
        return getFreeRooms().size();
    }

    @Override
    public ArrayList<Room> getFreeRooms() {
        ArrayList<Room> freeRooms = new ArrayList<>();
        for (Room r : roomRepository.Fetch()) {
            if (r.getStatus().equals(RoomStatus.free)) {
                freeRooms.add(r);
            }
        }

        return freeRooms;
    }

    @Override
    public void getRoomDetailsById(int roomId) {
        for (Room r : roomRepository.Fetch()) {
            if (r.id == roomId) {
                System.out.println(r);
                break;
            }
        }

        System.out.println(Literals.roomNotFound);
    }
}