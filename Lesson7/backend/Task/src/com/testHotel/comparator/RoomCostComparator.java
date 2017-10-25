
package com.testHotel.comparator;

import com.testHotel.entity.Room;
import com.testHotel.services.NullCheck;

import java.io.Serializable;
import java.util.Comparator;

public class RoomCostComparator implements Comparator<Room>,Serializable {

    @Override
    public int compare(Room room1, Room room2) {

        int nullParameter = NullCheck.check(room1.getCost(), room2.getCost());

        if (nullParameter == 2) {
            Integer room1Cost = room1.getCost();
            Integer room2Cost = room2.getCost();
            return room1Cost.compareTo(room2Cost);

        } else {
            return nullParameter;
        }


    }
}