package Comparator;

import Domain.Entities.GuestRoomInfo;

import java.util.Comparator;

public class GuestInfoNameComparator implements Comparator<GuestRoomInfo> {
    @Override
    public int compare(GuestRoomInfo gi1, GuestRoomInfo gi2) {
        String name1 = gi1.getGuest().getSurName();
        String name2 = gi2.getGuest().getSurName();
        return name1.compareTo(name2);
    }
}