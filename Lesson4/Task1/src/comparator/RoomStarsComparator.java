
package comparator;

import entity.Room;

import java.util.Comparator;

public class RoomStarsComparator implements Comparator<Room> {

    @Override
    public int compare(Room room1, Room room2) {
        try {
            Integer room1Stars = room1.getStars();
            Integer room2Stars = room2.getStars();
            return room1Stars.compareTo(room2Stars);
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;

    }
}
