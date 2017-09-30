package Comparator;

import Domain.Entities.Room;

import java.util.Comparator;

public class RoomCostComparator implements Comparator<Room>{



    @Override
    public int compare(Room room1, Room room2) {
        Integer room1Cost=room1.getCost();
        Integer room2Cost=room2.getCost();
        return room1Cost.compareTo(room2Cost);

    }
}
