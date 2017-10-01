import Storage.*;
import entity.*;
import services.*;



public class Main {


    public static void main(String[] args) {
        RoomStorage roomStorage=new RoomStorage();
        GuestRoomInfoStorage guestRoomInfoStorage=new GuestRoomInfoStorage();
        GuestStorage guestStorage=new GuestStorage();
        RoomService roomService=new RoomService(roomStorage,guestRoomInfoStorage,guestStorage);
        ServiceStorage serviceStorage=new ServiceStorage();
        GuestServiceStorage guestServiceStorage=new GuestServiceStorage();
        GuestService guestService=new GuestService(guestRoomInfoStorage);
        ServiceService serviceService=new ServiceService(guestServiceStorage);
        PrinterService printerService=new PrinterService();

        Guest guest1 = new Guest(1,"Bob", "White");
        Guest guest2 = new Guest(1,"Alice", "White");
        Guest guest3 = new Guest(1,"Nadya", "White");

        Service service1=new Service(1,ServiceType.eat,"Vodka",10);
        Service service2=new Service(1,ServiceType.eat,"Pelmeni",15);
        Service service3=new Service(1,ServiceType.spa,"Spa",20);
        serviceStorage.addEntity(service1);
        serviceStorage.addEntity(service2);
        serviceStorage.addEntity(service3);




        Hotel bestHotel=new Hotel("bestHotel",serviceService,roomService, guestService,printerService);

        bestHotel.readRoomsFromFile("D:\\Rooms.txt");
        bestHotel.printAllRooms();
        bestHotel.printRoomsSortingByCapacity();
        bestHotel.printRoomsSortingByCost();
        bestHotel.printRoomsSortingByStars();
        bestHotel.addGuest(1,guest1,2018,5,12);
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
        bestHotel.printFreeRoomsByDate(2018,4,12);
        bestHotel.printGuestPayAmount(guest1);
        bestHotel.printLastThreeGuestsInRoom(1);
        bestHotel.addGuestService(guest1,service1,2018,10,2);
        bestHotel.printGuestServices(guest1);
        bestHotel.printGuestServicesByDate(guest1);
        bestHotel.printGuestServicesByCost(guest1);
        bestHotel.printLastThreeGuestsInRoom(1);




        }

    }


