package com.testHotel.comparator;

import com.testHotel.entity.Room;
import com.testHotel.service.NullCheck;

import java.util.Comparator;

public class RoomIdComparator implements Comparator<Room>{
    @Override
    public int compare(Room room1, Room room2) {

        int nullParameter = NullCheck.check(room1.getId(), room2.getId());

        if (nullParameter == 2) {
            Integer room1id = room1.getId();
            Integer room2id = room2.getId();
            return room1id.compareTo(room2id);
        } else {
            return nullParameter;
        }

    }
}
