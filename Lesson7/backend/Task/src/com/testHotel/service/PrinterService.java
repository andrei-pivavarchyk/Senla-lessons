package com.testHotel.service;


import com.testHotel.entity.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PrinterService implements IPrinterService {

    public void printRooms(List<Room> roomList) {

        for (Room room : roomList) {

            System.out.println(room);

        }
        System.out.println("Rooms was printed");
    }

    public void printGuestsWithRoomNumbers(List<GuestRoomInfo> guestRoomInfoList) {

        for (GuestRoomInfo guestRoomInfo : guestRoomInfoList) {
            Guest guest = guestRoomInfo.getGuest();
            System.out.print(guest);
            System.out.println(new StringBuilder("Room number: ").append(guestRoomInfo.getRoom().getNumber()));

        }
        System.out.println("Guests was printed");

    }

    public void printGuests(List<Guest> guestList) {
        for (Guest guest : guestList) {
            System.out.println(guest);
        }

        System.out.println("Guests was printed");
    }

    public void printGuestsWithDates(List<GuestRoomInfo> guestRoomInfoList) {

        for (GuestRoomInfo guestRoomInfo : guestRoomInfoList) {
            Guest guest = guestRoomInfo.getGuest();
            Date arrivalDate = guestRoomInfo.getArrivalDate();
            Date departureDate = guestRoomInfo.getDepartureDate();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");


            System.out.println(guest + " Arrival date: " + dateFormat.format(arrivalDate) + "Departure date: " + dateFormat.format(departureDate));
        }

    }

    public void printGuestServices(ArrayList<GuestServiceInfo> guestServiceInfoList) {

        for (GuestServiceInfo guestServiceInfo : guestServiceInfoList) {

            Guest guest = guestServiceInfo.getGuest();
            Service service = guestServiceInfo.getService();

            System.out.println(service);
        }

    }
    public void printServices(List<Service> serviceList){
        for (Service service : serviceList) {
            System.out.println(service);
        }

    }

    public void printString(String string){
        System.out.println(string);
    }

}
