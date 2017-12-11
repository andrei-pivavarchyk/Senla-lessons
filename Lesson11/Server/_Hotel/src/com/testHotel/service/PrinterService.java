package com.testHotel.service;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.testHotel.entity.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PrinterService implements IPrinterService {


    public PrinterService() {
    }

    public void printRooms(List<Room> roomList) {

        for (Room room : roomList) {

            System.out.println(room);

        }

    }

    public void printGuestsWithRoomNumbers(List<GuestRoomInfo> guestRoomInfoList) {

        for (GuestRoomInfo guestRoomInfo : guestRoomInfoList) {
            Guest guest = guestRoomInfo.getGuest();
            System.out.print(guest);
            System.out.println(new StringBuilder("Room number: ").append(guestRoomInfo.getRoom().getNumber()));

        }


    }

    public void printGuests(List<Guest> guestList) {
        for (Guest guest : guestList) {
            System.out.println(guest);
        }


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

    public void printGuestServices(List<GuestServiceInfo> guestServiceInfoList) {

        for (GuestServiceInfo guestServiceInfo : guestServiceInfoList) {

            Guest guest = guestServiceInfo.getGuest();
            Service service = guestServiceInfo.getService();

            System.out.println(service);
        }

    }

    public void printServices(List<Service> serviceList) {
        for (Service service : serviceList) {
            System.out.println(service);
        }

    }

    public void printString(String string) {
        System.out.println(string);
    }


}
