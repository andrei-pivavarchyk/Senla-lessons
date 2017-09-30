package Comparator;

import Domain.Entities.RoomGuestInfo;

import java.util.Comparator;

public class GuestInfoNameComparator implements Comparator<RoomGuestInfo> {
    @Override
    public int compare(RoomGuestInfo gi1, RoomGuestInfo gi2) {
        String name1 = gi1.getGuest().getSurName();
        String name2 = gi2.getGuest().getSurName();
        return name1.compareTo(name2);
    }
}