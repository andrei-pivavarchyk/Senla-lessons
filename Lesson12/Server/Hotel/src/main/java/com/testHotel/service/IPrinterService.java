package com.testHotel.service;

import com.testHotel.entity.*;

import java.util.ArrayList;
import java.util.List;

public interface IPrinterService {


    void printRooms(List<Room> roomList);
    void printGuestsWithRoomNumbers(List<GuestRoomInfo> guestRoomInfoList);
    void printGuests(List<Guest> guestList);
    void printGuestsWithDates(List<GuestRoomInfo> guestRoomInfoList);
    void printGuestServices(List<GuestServiceInfo> guestServiceInfoList);
    void printServices(List<Service> serviceList);
    void printString(String string);
}
