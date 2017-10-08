import entity.*;



public class Main {


    public static void main(String[] args) {
       startHotel();
    }

    private static void startHotel(){

        //creating guests
        Guest guest1 = new Guest(1, "Bob", "White");
        Guest guest2 = new Guest(1, "Alice", "White");
        Guest guest3 = new Guest(1, "Nadya", "White");
        //creating services
        Service service1 = new Service(1, ServiceType.EAT, "Vodka", 10);
        Service service2 = new Service(1, ServiceType.EAT, "Pelmeni", 15);
        Service service3 = new Service(1, ServiceType.EAT, "Spa", 20);

        Hotel bestHotel = new Hotel();

        bestHotel.addService(service1);
        bestHotel.addService(service2);
        bestHotel.addService(service3);
        bestHotel.readRoomsFromFile("D:\\Rooms.txt");
        bestHotel.printAllRooms();
        bestHotel.printRoomsSortingByCapacity();
        bestHotel.printRoomsSortingByCost();
        bestHotel.printRoomsSortingByStars();
        bestHotel.addGuest(1, guest1, 2018, 5, 12);
        bestHotel.printFreeRooms();
        bestHotel.printFreeRoomsByStars();
        bestHotel.printFreeRoomsByCost();
        bestHotel.printFreeRoomsByCapacity();
        bestHotel.printAllGuests();
        bestHotel.printAllGuests();
        bestHotel.printGuestsSortedByName();
        bestHotel.printGuestsSortedByDepartureDate();
        bestHotel.printFreeRoomsCount();
        bestHotel.printAllGuestsCount();
        bestHotel.printFreeRoomsByDate(2018, 4, 12);
        bestHotel.printGuestPayAmount(guest1);
        bestHotel.printLastThreeGuestsInRoom(1);
        bestHotel.addGuestService(guest1, service1, 2018, 10, 2);
        bestHotel.printGuestServices(guest1);
        bestHotel.printGuestServicesByDate(guest1);
        bestHotel.printGuestServicesByCost(guest1);
        bestHotel.printLastThreeGuestsInRoom(1);
        bestHotel.setRoomCost(1, 12, "D:\\Rooms.txt");
        bestHotel.printAllRooms();
    }

}

