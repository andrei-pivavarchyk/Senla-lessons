package com.testHotel.services;


import com.testHotel.entity.Guest;
import com.testHotel.entity.GuestRoomInfo;
import com.testHotel.storage.IGuestRoomInfoStorage;

import java.util.ArrayList;

public interface IGuestService {

    ArrayList<Guest> getAllGuests();
    ArrayList<Guest> getAllGuestsSortedByName();
    ArrayList<Guest> getAllGuestsSortedByDateDeparture();
    void printAllGuestsCount();
    int getPayAmount(Guest guest);
    ArrayList<GuestRoomInfo> getCurrentGuestRoomInfo();
    void setGuestRoomInfoStorage(IGuestRoomInfoStorage guestRoomInfoStorage);
}
