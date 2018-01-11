package com.testHotel.service;


import com.dao.TypeSorting;
import com.entity.Guest;
import com.entity.GuestRoomInfo;
import java.util.List;
public interface IGuestService {

    List<Guest> getAllGuests(TypeSorting sorting);
     Long getAllGuestsCount();
    Integer getPayAmount(Guest guest);
    List<GuestRoomInfo> getCurrentGuestRoomInfo();
    Guest getGuestById(Integer id);
    void addGuest(Guest guest);
    void removeGuest(Integer id);
    void updateGuest(Guest guest);
}
