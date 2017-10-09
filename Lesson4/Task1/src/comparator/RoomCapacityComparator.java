
package comparator;

import entity.Room;

import java.util.Comparator;

public class RoomCapacityComparator implements Comparator<Room> {

    @Override
    public int compare(Room room1, Room room2) {
        try {
            Integer room1Capacity = room1.getCapacity();
            Integer room2Capacity = room2.getCapacity();
            return room1Capacity.compareTo(room2Capacity);
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

}
