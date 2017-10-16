
package comparator;

import entity.Room;
import services.NullCheck;

import java.util.Comparator;

public class RoomStarsComparator implements Comparator<Room> {

    @Override
    public int compare(Room room1, Room room2) {

        int nullParameter = NullCheck.check(room1.getStars(), room2.getStars());

        if (nullParameter == 2) {
            Integer room1Stars = room1.getStars();
            Integer room2Stars = room2.getStars();
            return room1Stars.compareTo(room2Stars);
        } else {
            return nullParameter;
        }

    }
}