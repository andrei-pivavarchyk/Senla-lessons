

public class Main {


    public  static void main(String[] args){

        Hotel bestHotel=new Hotel("BestHotel");
        Guest guest=new Guest("Bob", "White");
        Room room1=new Room(1,7,2,5);
        Room room2=new Room(2,5,1,4);
        Room room3=new Room(3,16,15,3);


        bestHotel.addRoom(room1);
        bestHotel.addRoom(room2);
        bestHotel.addRoom(room3);

        bestHotel.addGuest(guest,room1);


        PrintRooms.printAllRooms(bestHotel.getAllRooms());
        PrintRooms.printAllRooms(RoomSorting.roomCostSorting(bestHotel));
        PrintRooms.printAllRooms(bestHotel.getAllRooms());









    }

}
