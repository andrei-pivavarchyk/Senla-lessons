import java.util.ArrayList;

public class RoomSorting {

    public static ArrayList roomCostSorting(Hotel hotel){


        ArrayList<Room> copyArray= new ArrayList<Room>(hotel.getAllRooms());
        copyArray.sort(new RoomCostComparator());
        return copyArray;
    }

}
