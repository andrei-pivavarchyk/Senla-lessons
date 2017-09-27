import com.danco.training.TextFileWorker;
import entity.Guest;
import entity.Hotel;
import entity.Room;
import guestService.Service;
import services.HotelService;
import sorting.ServiceSorting;


import java.util.ArrayList;

import static guestService.ServiceType.eat;
import static guestService.ServiceType.spa;


public class Main {


    public static void main(String[] args) {


        Hotel bestHotel = new Hotel("bestHotel");

        //Adding rooms from file
        String[] allRooms = new TextFileWorker("D:\\Rooms.txt").readFromFile();
        for (String roomFromFile : allRooms) {
            String[] roomParametrs = roomFromFile.split("\\|");
            int roomNumber = Integer.parseInt(roomParametrs[0]);
            int roomCost = Integer.parseInt(roomParametrs[1]);
            int roomCapacity = Integer.parseInt(roomParametrs[2]);
            int roomStars = Integer.parseInt(roomParametrs[3]);

            Room room = new Room(roomNumber, roomCost, roomCapacity, roomStars);
            bestHotel.addRoom(room);
        }

        //Creating Guests
        Guest guest1 = new Guest("Bob", "White");
        Guest guest2 = new Guest("Alice", "White");
        Guest guest3 = new Guest("Nadya", "White");

        //Printing and sorting rooms by cost, capacity and stars
        System.out.println("Printing all rooms and sorting rooms by cost, capacity and stars");
        HotelService.printAllRooms(bestHotel);
        HotelService.printRoomsByParametr(bestHotel, "cost");
        HotelService.printRoomsByParametr(bestHotel, "capacity");
        HotelService.printRoomsByParametr(bestHotel, "stars");


        //Adding guests
        bestHotel.addGuestToRoom(1, guest1, 2018, 8, 11);
        bestHotel.addGuestToRoom(1, guest2, 2018, 7, 11);
        bestHotel.addGuestToRoom(1, guest3, 2018, 8, 11);


        //Printing free rooms and sorting by cost, capacity and stars
        System.out.println("Printing all free rooms and sorting rooms by cost, capacity and stars");

        HotelService.printFreeRooms(bestHotel);
        HotelService.printFreeRoomsByParametr(bestHotel, "cost");
        HotelService.printFreeRoomsByParametr(bestHotel, "stars");
        HotelService.printFreeRoomsByParametr(bestHotel, "capacity");


        //Printing Guests and sorting by name and departure date
        System.out.println("Printing Guests and sorting by name and departure date");

        HotelService.printAllGuests(bestHotel);
        HotelService.printAllGuestsByParametr(bestHotel, "name");
        HotelService.printAllGuestsByParametr(bestHotel, "departureDate");

        //Free rooms count
        HotelService.printFreeRoomsCount(bestHotel);
        HotelService.printAllGuestsCount(bestHotel);


        //Free rooms By Date
        System.out.println("Free rooms by Date 2018.07.12");


       HotelService.printFreeRoomsByDate(bestHotel, 2018, 8, 10);


        //Print pay guest
        System.out.println(guest1.getPay() + " $");
        //Print last three guests in room
        bestHotel.getAllRooms().get(0).printLastThreeGuests();

        System.out.println("Create service, adding to guest");
        Service service1 = new Service("Vodka", 55, eat);
        Service service2 = new Service("Cola", 55, eat);
        Service service3 = new Service("SomeSpa", 55, spa);

        bestHotel.addService(service1);
        bestHotel.addService(service2);
        bestHotel.addService(service3);


        guest1.addService(service1, 2018, 10, 11);
        guest1.addService(service2, 2018, 9, 11);
        guest1.addService(service3, 2018, 8, 11);

       HotelService.printServices(guest1.getAllGuestService());
        HotelService.printServices(ServiceSorting.serviceCostSorting(bestHotel.getAllServices()));
        HotelService.printServices(ServiceSorting.serviceDateSorting(bestHotel.getAllServices()));


    }

}
