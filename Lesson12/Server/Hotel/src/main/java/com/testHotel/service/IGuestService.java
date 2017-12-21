package com.testHotel.service;


import com.entity.Guest;
import com.entity.GuestRoomInfo;
import java.util.List;
public interface IGuestService {

    List<Guest> getAllGuests();
    List<Guest> getAllGuestsSortedByName();
    List<Guest> getAllGuestsSortedByDateDeparture();
    Integer getAllGuestsCount();
    Integer getPayAmount(Guest guest);
    List<GuestRoomInfo> getCurrentGuestRoomInfo();
}
