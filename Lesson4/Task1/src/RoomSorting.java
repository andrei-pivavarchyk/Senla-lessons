import java.util.ArrayList;

public class RoomSorting {

    public static ArrayList roomCostSorting(ArrayList<Room> ListOfRooms){
        ArrayList<Room> copyArray= new ArrayList<Room>(ListOfRooms);
        copyArray.sort(new RoomCostComparator());
        return copyArray;
    }

    public static ArrayList roomCapacitySorting(ArrayList<Room> ListOfRooms){
        ArrayList<Room> copyArray= new ArrayList<Room>(ListOfRooms);
        copyArray.sort(new RoomCapacityCorporator());
        return copyArray;
    }

    public static ArrayList roomStarsSorting(ArrayList<Room> ListOfRooms){
        ArrayList<Room> copyArray= new ArrayList<Room>(ListOfRooms);
        copyArray.sort(new RoomStarsComparator());
        return copyArray;
    }


}
