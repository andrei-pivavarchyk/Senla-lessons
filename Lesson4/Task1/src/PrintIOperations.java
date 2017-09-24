import java.lang.reflect.Array;
import java.util.ArrayList;

public class PrintIOperations {
    public static void printAllRooms(ArrayList<Room> allRooms) {


        for (int i = 0; i < allRooms.size(); i++) {
            StringBuilder text=new StringBuilder();

          text.append("Room  number:");
          text.append(allRooms.get(i).getNumber());
          text.append(" cost: ");
          text.append(allRooms.get(i).getCost());
          text.append(" capacity: ");
          text.append( allRooms.get(i).getCapacity());
          text.append(" stars: "+allRooms.get(i).getStars());
            System.out.println(text);

        }
        System.out.println("Rooms was printed");


    }

    public static void printAllGuests(ArrayList<Guest> allGuests){

        for (int i = 0; i <allGuests.size(); i++) {
            StringBuilder text=new StringBuilder();
            text.append(allGuests.get(i).getName()+" ");
            text.append(allGuests.get(i).getSurName()+" ");
            text.append("Room number ");
            text.append(allGuests.get(i).getGuestRoom().getNumber());
            System.out.println(text);

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
