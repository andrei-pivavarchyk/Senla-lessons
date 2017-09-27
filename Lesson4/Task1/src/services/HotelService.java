package services;


import entity.Guest;
import entity.Hotel;
import entity.Room;
import entity.RoomStatus;
import guestService.Service;
import sorting.GuestSorting;
import sorting.RoomSorting;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class HotelService {

    public Hotel hotel;
    public HotelService(Hotel hotel){
        this.hotel=hotel;
    }

    public  void printAllRooms() {
        ArrayList<Room> allRooms = hotel.getAllRooms();
        printRooms(allRooms);
        System.out.println("Rooms was printed");
    }
    public void printFreeRooms() {
        ArrayList<Room> freeRooms = this.getFreeRooms();
        printRooms(freeRooms);
        System.out.println("Rooms was printed");

    }


    public void addRoom(Room room) {
        this.hotel.getAllRooms().add(room);
        room.setHotel(this.hotel);
        System.out.println(new StringBuilder("Room number: ").append(room.getNumber()).append(" was added"));
    }

    public void removeRoom(Room room) {
        if (this.hotel.getAllRooms().contains(room)) {
            this.hotel.getAllRooms().remove(room);
        } else {
            System.out.println(Literals.guestNotFoundInRoom);
        }

    }



    public ArrayList<Room> getFreeRooms() {
        ArrayList<Room> freeRooms = new ArrayList<Room>();
        for (int i = 0; i <this.hotel.getAllRooms().size(); i++) {
            if (this.hotel.getAllRooms().get(i).getStatus().equals(RoomStatus.free)) {
                freeRooms.add(this.hotel.getAllRooms().get(i));
            }

        }
        return freeRooms;
    }

    private void printRooms(ArrayList<Room> rooms) {
        for (Room r : rooms) {
            System.out.println(r);
        }
    }

    public  void printRoomsByParametr( String parametr) {
        ArrayList<Room> allRooms = this.hotel.getAllRooms();
        printRooms(sortRoomsBy(allRooms,parametr));

    }
    public void printFreeRoomsByParametr( String parametr) {
        ArrayList<Room> freeRooms =this.getFreeRooms();
      printRooms(sortRoomsBy(freeRooms,parametr));


    }

    private ArrayList<Room> sortRoomsBy(ArrayList<Room> rooms, String parametr){
        ArrayList<Room> roomSortingList=new ArrayList<Room>();
        if (parametr.equals("cost")) {
             roomSortingList = RoomSorting.roomCostSorting(rooms);

        } else if (parametr.equals("capacity")) {

            roomSortingList = RoomSorting.roomCapacitySorting(rooms);

        } else if (parametr.equals("stars")) {
            roomSortingList = RoomSorting.roomStarsSorting(rooms);


        }
return roomSortingList;
    }


    public  void printFreeRoomsByDate( int year, int month, int day) {

        Date date = new GregorianCalendar(year, month + 1, day).getTime();
        ArrayList<Room> freeRoomsByDate = new ArrayList<Room>();
        for (Room room : this.getFreeRooms()) {
            if (room.getDateDeparture() != null) {
                if (room.getDateDeparture().compareTo(date) == -1) {
                    freeRoomsByDate.add(room);
                }
            }
        }
        freeRoomsByDate.addAll(this.getFreeRooms());

        for (int i = 0; i < freeRoomsByDate.size(); i++) {

            System.out.println(freeRoomsByDate.get(i));
        }
        System.out.println("Rooms was printed");



    }

    public  void printAllGuests() {
        ArrayList<Guest> allGuests = hotel.getAllGuests();
        for (int i = 0; i < allGuests.size(); i++) {

            System.out.println(allGuests.get(i));
        }
        System.out.println("Guests was printed");

    }

    public  void printAllGuestsByParametr( String parametr) {

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
    private Room findRoomByNumber(int roomNumber) {
        Room currentRoom;
        for (Room room : this.hotel.getAllRooms()) {
            if (room.getNumber() == roomNumber) {
                currentRoom = room;
                return currentRoom;
            }
        }
        return null;
    }

    public void addService(Service service) {
        this.hotel.getAllServices().add(service);
    }

    public void addGuestToRoom(int roomNumber, Guest guest, int year, int month, int day) {
        Room currentRoom = this.findRoomByNumber(roomNumber);
        if (currentRoom != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month, day);
            currentRoom.addGuest(guest, calendar.getTime());
        } else {
            System.out.print("There is no room with this number");
        }
    }

    public int getFreeRoomsCount() {
        return this.getFreeRooms().size();
    }

    public void printFreeRoomsCount() {
        System.out.println(new StringBuilder("Free rooms count ").append(this.getFreeRoomsCount()));
    }

    public  void printAllGuestsCount() {
        System.out.println(new StringBuilder("All guests count ").append(this.hotel.getAllGuests().size()));
    }



    public static void printServices(ArrayList<Service> listService){
        for (int i = 0; i < listService.size(); i++) {

            System.out.println(listService.get(i));
        }
        System.out.println("Guest Services was printed");
    }


    }






