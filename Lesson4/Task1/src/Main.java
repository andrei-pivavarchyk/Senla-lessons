import com.danco.training.TextFileWorker;
import entity.Guest;
import entity.Hotel;
import entity.Room;
import entity.Service;
import services.PrintOperations;
import services.RoomService;
import sorting.GuestSorting;
import sorting.RoomSorting;


import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Main {


    public  static void main(String[] args){


        Hotel bestHotel=new Hotel("bestHotel");

        //Adding rooms from file
        String[] allRooms= new TextFileWorker("D:\\Rooms.txt").readFromFile();
        for(String roomFromFile: allRooms){
            String[] roomParametrs=roomFromFile.split("\\|");
            int roomNumber=Integer.parseInt(roomParametrs[0]);
            int roomCost=Integer.parseInt(roomParametrs[1]);
            int roomCapacity=Integer.parseInt(roomParametrs[2]);
            int roomStars=Integer.parseInt(roomParametrs[3]);

            Room room=new Room(roomNumber,roomCost,roomCapacity,roomStars);
            bestHotel.addRoom(room);
        }

        //Creating Guests
        Guest guest1= new Guest("Bob","White");
        Guest guest2= new Guest("Alice","White");
        Guest guest3= new Guest("Nadya","White");

        //Printing and sorting rooms by cost, capacity and stars
        System.out.println("Printing all rooms and sorting rooms by cost, capacity and stars");
        PrintOperations.printAllRooms(bestHotel.getAllRooms());
        PrintOperations.printAllRooms( RoomSorting.roomCostSorting(bestHotel.getAllRooms()));
        PrintOperations.printAllRooms( RoomSorting.roomCapacitySorting(bestHotel.getAllRooms()));
        PrintOperations.printAllRooms( RoomSorting.roomStarsSorting(bestHotel.getAllRooms()));


       //Adding guests
        bestHotel.addGuestToRoom(1,guest1,2018,8,11);
        bestHotel.addGuestToRoom(1,guest2,2018,7,11);
        bestHotel.addGuestToRoom(1,guest3,2018,8,11);



        //Printing free rooms and sorting by cost, capacity and stars
        System.out.println("Printing all free rooms and sorting rooms by cost, capacity and stars");
        PrintOperations.printAllRooms(bestHotel.getFreeRooms());
        ArrayList<Room> freeRoomsByCost=RoomSorting.roomCostSorting(bestHotel.getFreeRooms());
        ArrayList<Room> freeRoomsByCapacity=RoomSorting.roomCapacitySorting(bestHotel.getFreeRooms());
        ArrayList<Room> freeRoomsByStars=RoomSorting.roomStarsSorting(bestHotel.getFreeRooms());
        PrintOperations.printAllRooms(freeRoomsByCost);
        PrintOperations.printAllRooms(freeRoomsByCapacity);
        PrintOperations.printAllRooms(freeRoomsByStars);

        //Printing Guests and sorting by name and departure date
        System.out.println("Printing Guests and sorting by name and departure date");
        PrintOperations.printAllGuests(bestHotel.getAllGuests());
        ArrayList<Guest> guestsSortingByDepartureDate=GuestSorting.guestDepartureDateSorting(bestHotel.getAllGuests());
        ArrayList<Guest> guestsSortingByName=GuestSorting.guestNameSorting(bestHotel.getAllGuests());
        PrintOperations.printAllGuests(guestsSortingByDepartureDate);
        PrintOperations.printAllGuests(guestsSortingByName);


        //Free rooms count
        System.out.println(new StringBuilder("Free rooms count ").append(bestHotel.getFreeRoomsCount()));
        System.out.println(new StringBuilder("All guests count ").append(bestHotel.getAllGuestsCount()));


       //Free rooms By Date
        System.out.println("Free rooms by Date 2018.07.12");
        ArrayList<Room> freeRoomByDate=bestHotel.getFreeRoomsByDate(2018,8,10);
        PrintOperations.printAllRooms(freeRoomByDate);

        //Print pay guest
        System.out.println( guest1.getPay()+" $");

       bestHotel.getAllRooms().get(0).printLastThreeGuests();















    }

}
