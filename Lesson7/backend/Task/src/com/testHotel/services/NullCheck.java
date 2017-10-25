package com.testHotel.services;


public class NullCheck {
    public static int check(Object object1, Object object2) {

        if (object1.equals(null) && object2.equals(null)) {
            return 0;
        } else if (object1.equals(null)) {
            return -1;
        } else if (object2.equals(null)) {

            return 1;
        }
        return 2;
    }
}
