package com.testHotel.service;



import com.dao.TypeSorting;
import com.testHotel.entity.Guest;
import com.testHotel.entity.GuestRoomInfo;
import com.testHotel.storage.IGuestRoomInfoStorage;

import java.util.ArrayList;
import java.util.List;

public interface IGuestService {

    List<Guest> getAllGuests();
    List<Guest> getAllGuestsSortedByName();
    List<Guest> getAllGuestsSortedByDateDeparture();
    Integer getAllGuestsCount();
    Integer getPayAmount(Guest guest);
    List<GuestRoomInfo> getCurrentGuestRoomInfo();
}
