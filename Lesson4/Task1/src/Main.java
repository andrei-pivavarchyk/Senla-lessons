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
        HotelService hotelService=new HotelService(bestHotel);


        //Adding rooms from file
        String[] allRooms = new TextFileWorker(args[0]).readFromFile();
        for (String roomFromFile : allRooms) {
            String[] roomParametrs = roomFromFile.split("\\|");
            int roomNumber = Integer.parseInt(roomParametrs[0]);
            int roomCost = Integer.parseInt(roomParametrs[1]);
            int roomCapacity = Integer.parseInt(roomParametrs[2]);
            int roomStars = Integer.parseInt(roomParametrs[3]);

            Room room = new Room(roomNumber, roomCost, roomCapacity, roomStars);
            hotelService.addRoom(room);
        }

        //Creating Guests
        Guest guest1 = new Guest("Bob", "White");
        Guest guest2 = new Guest("Alice", "White");
        Guest guest3 = new Guest("Nadya", "White");

        //Printing and sorting rooms by cost, capacity and stars
        System.out.println("Printing all rooms and sorting rooms by cost, capacity and stars");
        hotelService.printAllRooms();
        hotelService.printRoomsByParametr( "cost");
        hotelService.printRoomsByParametr( "capacity");
        hotelService.printRoomsByParametr( "stars");


        //Adding guests
        hotelService.addGuestToRoom(1, guest1, 2018, 8, 11);
        hotelService.addGuestToRoom(1, guest2, 2018, 7, 11);
        hotelService.addGuestToRoom(1, guest3, 2018, 8, 11);


        //Printing free rooms and sorting by cost, capacity and stars
        System.out.println("Printing all free rooms and sorting rooms by cost, capacity and stars");

        hotelService.printFreeRooms();
        hotelService.printFreeRoomsByParametr( "cost");
        hotelService.printFreeRoomsByParametr( "stars");
        hotelService.printFreeRoomsByParametr( "capacity");


        //Printing Guests and sorting by name and departure date
        System.out.println("Printing Guests and sorting by name and departure date");

        hotelService.printAllGuests();
        hotelService.printAllGuestsByParametr( "name");
        hotelService.printAllGuestsByParametr( "departureDate");

        //Free rooms count
        hotelService.printFreeRoomsCount();
        hotelService.printAllGuestsCount();


        //Free rooms By Date
        System.out.println("Free rooms by Date 2018.07.12");


        hotelService.printFreeRoomsByDate( 2018, 8, 10);


        //Print pay guest
        System.out.println(guest1.getPay() + " $");
        //Print last three guests in room
        bestHotel.getAllRooms().get(0).printLastThreeGuests();

        System.out.println("Create service, adding to guest");
        Service service1 = new Service("Vodka", 55, eat);
        Service service2 = new Service("Cola", 55, eat);
        Service service3 = new Service("SomeSpa", 55, spa);

        hotelService.addService(service1);
        hotelService.addService(service2);
        hotelService.addService(service3);


        guest1.addService(service1, 2018, 10, 11);
        guest1.addService(service2, 2018, 9, 11);
        guest1.addService(service3, 2018, 8, 11);

        HotelService.printServices(guest1.getAllGuestService());
        HotelService.printServices(ServiceSorting.serviceCostSorting(bestHotel.getAllServices()));
        HotelService.printServices(ServiceSorting.serviceDateSorting(bestHotel.getAllServices()));


    }

}
