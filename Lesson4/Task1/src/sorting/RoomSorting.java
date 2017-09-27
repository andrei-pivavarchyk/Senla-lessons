package sorting;

import comparator.RoomCapacityComparator;
import comparator.RoomCostComparator;
import comparator.RoomStarsComparator;
import entity.Room;

import java.util.ArrayList;

public class RoomSorting {

    public static ArrayList roomCostSorting(ArrayList<Room> ListOfRooms){
        ArrayList<Room> copyArray= new ArrayList<Room>(ListOfRooms);
        copyArray.sort(new RoomCostComparator());
        return copyArray;
    }

    public static ArrayList roomCapacitySorting(ArrayList<Room> ListOfRooms){
        ArrayList<Room> copyArray= new ArrayList<Room>(ListOfRooms);
        copyArray.sort(new RoomCapacityComparator());
        return copyArray;
    }

    public static ArrayList roomStarsSorting(ArrayList<Room> ListOfRooms){
        ArrayList<Room> copyArray= new ArrayList<Room>(ListOfRooms);
        copyArray.sort(new RoomStarsComparator());
        return copyArray;
    }


}
