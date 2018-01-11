package com.testHotel.service;


import com.entity.Guest;
import com.entity.GuestRoomInfo;
import java.util.List;
public interface IGuestService {

    List<Guest> getAllGuests();
    List<Guest> getAllGuestsSortedByName();
    List<Guest> getAllGuestsSortedByDateDeparture();
     Long getAllGuestsCount();
    Integer getPayAmount(Guest guest);
    List<GuestRoomInfo> getCurrentGuestRoomInfo();
    Guest getGuestById(Integer id);
    void addGuest(Guest guest);
    void removeGuest(Guest guest);
    void updateGuest(Guest guest);
}
