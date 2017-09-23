import java.util.ArrayList;

public class PrintRooms {
    public static void printAllRooms(ArrayList<Room> allRooms) {

        for (int i = 0; i < allRooms.size(); i++) {


            System.out.println( new StringBuilder("Room  number:" + allRooms.get(i).getNumber() + " cost: " + allRooms.get(i).getCost() + " capacity: " + allRooms.get(i).getCapacity()+" stars: "+allRooms.get(i).getStars()));

        }

    }
}
