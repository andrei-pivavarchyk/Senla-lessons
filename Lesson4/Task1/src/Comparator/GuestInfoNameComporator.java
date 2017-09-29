package Comparator;

import Entity.GuestInfo;

import java.util.Comparator;

public class GuestInfoNameComporator implements Comparator<GuestInfo> {
    @Override
    public int compare(GuestInfo gi1, GuestInfo gi2) {
        String name1 = gi1.getGuest().getSurName();
        String name2 = gi2.getGuest().getSurName();
        return name1.compareTo(name2);
    }
}
