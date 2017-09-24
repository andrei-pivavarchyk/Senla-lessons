import Entity.Guest;
import Entity.Hotel;
import Entity.Room;
import Entity.Service;
import Sorting.GuestSorting;

import java.util.GregorianCalendar;

public class Main {


    public  static void main(String[] args){

        Hotel bestHotel=new Hotel("BestHotel");
        Guest guest1=new Guest("Bob", "White");
        Guest guest2=new Guest("Jak", "White");
        Guest guest3=new Guest("Nadya", "White");

        Room room1=new Room(1,7,2,5);
        Room room2=new Room(2,5,1,4);
        Room room3=new Room(3,16,15,3);

        bestHotel.addRoom(room1);
        bestHotel.addRoom(room2);
        bestHotel.addRoom(room3);


        room1.addGuest(guest1,new GregorianCalendar(2018,8,25).getTime());
        room1.addGuest(guest2,new GregorianCalendar(2018,10,11).getTime());



        //print all rooms
        Services.PrintIOperations.printAllRooms(bestHotel.getAllRooms());
        //print free rooms
        Services.PrintIOperations.printAllRooms(bestHotel.getFreeRooms());
        //print all guests
        Services.PrintIOperations.printAllGuests(bestHotel.getAllGuests());

        //SORTING GUESTS
        Services.PrintIOperations.printAllGuests( GuestSorting.guestNameSorting(bestHotel.getAllGuests()));
        Services.PrintIOperations.printAllGuests( GuestSorting.guestDepartureDateSorting(bestHotel.getAllGuests()));
        System.out.println(guest1.getPay()+"$ need pay");
        //Last Three Guests

        room1.outGuest(guest1);

        Services.PrintIOperations.printGuestsWithDate(room1.getlastThreeGuests());
















    }

}
