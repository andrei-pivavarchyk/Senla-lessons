
package comparator;

import entity.Room;

import java.util.Comparator;

public class RoomCostComparator implements Comparator<Room> {

    @Override
    public int compare(Room room1, Room room2) {
        try {
            Integer room1Cost = room1.getCost();
            Integer room2Cost = room2.getCost();
            return room1Cost.compareTo(room2Cost);
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;

    }
}
