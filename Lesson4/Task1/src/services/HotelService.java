package services;


import entity.Guest;
import entity.Hotel;
import entity.Room;
import entity.RoomStatus;
import guestService.Service;
import sorting.GuestSorting;
import sorting.RoomSorting;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class HotelService {

    public static void printAllRooms(Hotel hotel) {
        ArrayList<Room> allRooms = hotel.getAllRooms();
        for (int i = 0; i < allRooms.size(); i++) {

            System.out.println(allRooms.get(i));
        }
        System.out.println("Rooms was printed");
    }


    public static void printFreeRooms(Hotel hotel) {
        ArrayList<Room> freeRooms = hotel.getFreeRooms();
        for (int i = 0; i < freeRooms.size(); i++) {

            System.out.println(freeRooms.get(i));
        }
        System.out.println("Rooms was printed");

    }

    public static void printRoomsByParametr(Hotel hotel, String parametr) {
        ArrayList<Room> allRooms = hotel.getAllRooms();
        if (parametr.equals("cost")) {

            ArrayList<Room> roomSortingCostList = RoomSorting.roomCostSorting(allRooms);
            for (int i = 0; i < roomSortingCostList.size(); i++) {

                System.out.println(roomSortingCostList.get(i));
            }
            System.out.println("Rooms was printed");
        } else if (parametr.equals("capacity")) {

            ArrayList<Room> roomSortingCapacityList = RoomSorting.roomCapacitySorting(allRooms);
            for (int i = 0; i < roomSortingCapacityList.size(); i++) {

                System.out.println(roomSortingCapacityList.get(i));
            }
            System.out.println("Rooms was printed");
        } else if (parametr.equals("stars")) {
            ArrayList<Room> roomSortingStarsList = RoomSorting.roomStarsSorting(allRooms);
            for (int i = 0; i < roomSortingStarsList.size(); i++) {

                System.out.println(roomSortingStarsList.get(i));
            }
            System.out.println("Rooms was printed");

        }

    }


    public static void printFreeRoomsByParametr(Hotel hotel, String parametr) {
        ArrayList<Room> freeRooms =hotel.getFreeRooms();
        if (parametr.equals("cost")) {
            ArrayList<Room> roomSortingCostList = RoomSorting.roomCostSorting(freeRooms);
            for (int i = 0; i < roomSortingCostList.size(); i++) {

                System.out.println(roomSortingCostList.get(i));
            }
            System.out.println("Rooms was printed");
        } else if (parametr.equals("capacity")) {

            ArrayList<Room> roomSortingCapacityList = RoomSorting.roomCapacitySorting(freeRooms);
            for (int i = 0; i < roomSortingCapacityList.size(); i++) {

                System.out.println(roomSortingCapacityList.get(i));
            }
            System.out.println("Rooms was printed");
        } else if (parametr.equals("stars")) {
            ArrayList<Room> roomSortingStarsList = RoomSorting.roomStarsSorting(freeRooms);
            for (int i = 0; i < roomSortingStarsList.size(); i++) {

                System.out.println(roomSortingStarsList.get(i));
            }
            System.out.println("Rooms was printed");

        }

    }

    public static void printAllGuests(Hotel hotel) {
        ArrayList<Guest> allGuests = hotel.getAllGuests();
        for (int i = 0; i < allGuests.size(); i++) {

            System.out.println(allGuests.get(i));
        }
        System.out.println("Guests was printed");

    }

    public static void printAllGuestsByParametr(Hotel hotel, String parametr) {

        if (parametr.equals("name")) {

            ArrayList<Room> guestsSortingList = GuestSorting.guestNameSorting(hotel.getAllGuests());
            for (int i = 0; i < guestsSortingList.size(); i++) {

                System.out.println(guestsSortingList.get(i));
            }
            System.out.println("Rooms was printed");
        } else if (parametr.equals("departureDate")) {
            ArrayList<Room> guestsSortingList = GuestSorting.guestDepartureDateSorting(hotel.getAllGuests());
            for (int i = 0; i < guestsSortingList.size(); i++) {

                System.out.println(guestsSortingList.get(i));
            }
            System.out.println("Rooms was printed");

        }

    }

    public static void printFreeRoomsCount(Hotel hotel) {
        System.out.println(new StringBuilder("Free rooms count ").append(hotel.getFreeRoomsCount()));
    }

    public static void printAllGuestsCount(Hotel hotel) {
        System.out.println(new StringBuilder("All guests count ").append(hotel.getAllGuests().size()));
    }

    public static void printFreeRoomsByDate(Hotel hotel, int year, int month, int day) {

        Date date = new GregorianCalendar(year, month + 1, day).getTime();
        ArrayList<Room> freeRoomsByDate = new ArrayList<Room>();
        for (Room room : hotel.getFreeRooms()) {
            if (room.getDateDeparture() != null) {
                if (room.getDateDeparture().compareTo(date) == -1) {
                    freeRoomsByDate.add(room);
                }
            }
        }
        freeRoomsByDate.addAll(hotel.getFreeRooms());

        for (int i = 0; i < freeRoomsByDate.size(); i++) {

            System.out.println(freeRoomsByDate.get(i));
        }
        System.out.println("Rooms was printed");



    }
    public static void printAllHotelServices(Hotel hotel){


        for (int i = 0; i < hotel.getAllServices().size(); i++) {

            System.out.println(hotel.getAllServices().get(i));
        }
        System.out.println("Guest Services was printed");

    }
    public static void printServices(ArrayList<Service> listService){
        for (int i = 0; i < listService.size(); i++) {

            System.out.println(listService.get(i));
        }
        System.out.println("Guest Services was printed");
    }


    }






