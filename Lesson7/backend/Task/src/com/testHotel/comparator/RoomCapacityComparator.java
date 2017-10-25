
package com.testHotel.comparator;

import com.testHotel.entity.Room;
import com.testHotel.services.NullCheck;

import java.io.Serializable;
import java.util.Comparator;

public class RoomCapacityComparator implements Comparator<Room>,Serializable {

    @Override
    public int compare(Room room1, Room room2) {

        int nullParameter = NullCheck.check(room1.getCapacity(), room2.getCapacity());

        if (nullParameter == 2) {
            Integer room1Capacity = room1.getCapacity();
            Integer room2Capacity = room2.getCapacity();
            return room1Capacity.compareTo(room2Capacity);
        } else {
            return nullParameter;
        }

    }


}
