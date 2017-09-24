package Services;

import Entity.Guest;
import Entity.Room;

import java.util.ArrayList;

public class PrintIOperations {
    public static void printAllRooms(ArrayList<Room> allRooms) {


        for (int i = 0; i < allRooms.size(); i++) {

            System.out.println(allRooms.get(i));
        }
        System.out.println("Rooms was printed");

    }


    public static void printAllGuests(ArrayList<Guest> allGuests){

        for (int i = 0; i <allGuests.size(); i++) {

            System.out.println(allGuests.get(i));
        }
        System.out.println("Guests was printed");

    }

public static void printGuestsWithDate(ArrayList<Guest> allGuests){

    for (int i = 0; i <allGuests.size(); i++) {
        StringBuilder text=new StringBuilder();
        text.append("Name "+allGuests.get(i).getName());
        text.append(" Surname "+allGuests.get(i).getSurName());
        text.append(" DATE SINCE "+allGuests.get(i).getGuestInfo().getArrivalDate());
        text.append(" DATE FOR "+allGuests.get(i).getGuestInfo().getDepartureDate());
        System.out.println(text);

    }
    System.out.println("Guests with Date was printed");


}
}
