import DataLayer.GuestRoomInfoRepository;
import DataLayer.GuestServiceInfoRepository;
import DataLayer.RoomRepository;
import DataLayer.ServiceRepository;
import Domain.Contracts.IRoomRepository;
import Domain.Entities.Guest;
import Domain.Entities.Room;
import Domain.Entities.Service;
import Domain.Services.Contracts.IHotelService;
import Domain.Services.Contracts.IRoomService;
import Domain.Services.Contracts.IServiceService;
import Domain.Services.Implementation.HotelService;
import Domain.Services.Implementation.RoomService;
import Domain.Services.Implementation.ServiceService;
import Sorting.GuestInfoSortType;
import Sorting.RoomSortType;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        IRoomRepository irr = new RoomRepository();
        IRoomService roomService = new RoomService(new GuestRoomInfoRepository(), irr);
        Room r1 = new Room(215, 350, 5, 4, 1);
        Room r2 = new Room(216, 360, 3, 4, 2);
        Room r3 = new Room(217, 340, 4, 4, 3);
        Room r4 = new Room(218, 340, 4, 4, 4);

        roomService.addRoom(r1);
        roomService.addRoom(r2);
        roomService.addRoom(r3);
        roomService.addRoom(r4);
        System.out.println(roomService.getFreeRoomsCount());
        roomService.removeRoom(r4);
        System.out.println(roomService.getFreeRoomsCount());

        IHotelService ihs = new HotelService(new RoomService(new GuestRoomInfoRepository(),
                irr), new GuestRoomInfoRepository(), new GuestServiceInfoRepository());
        Guest g1 = new Guest("Jack", "Daniels", 1);
        Guest g2 = new Guest("Stack", "Overflow", 2);
        Guest g3 = new Guest("George", "Harrison", 3);
        Guest g4 = new Guest("Michael", "Jordan", 4);
        ihs.checkInGuest(r1, g1, new Date(2017, 1, 2), new Date(2017, 1, 3));
        ihs.checkInGuest(r1, g2, new Date(2017, 1, 2), new Date(2018, 1, 3));
        ihs.checkInGuest(r1, g3, new Date(2017, 1, 2), new Date(2018, 1, 3));
        ihs.checkInGuest(r1, g4, new Date(2017, 1, 2), new Date(2018, 1, 3));
        ihs.printCurrentLivingGuestsSortedBy(GuestInfoSortType.Name);
        ihs.checkOutGuest(r1, g2);
        ihs.printCurrentLivingGuestsSortedBy(GuestInfoSortType.Name);

        System.out.println("Current guest count: " + ihs.getCurrentLivingGuestsCount());
        ihs.printFreeRoomsByDate(new Date(2016, 1, 5));
        ihs.getPaymentForGuest(g1.id);
        roomService.printRoomsSortedBy(RoomSortType.Cost);
        roomService.getRoomDetailsById(r1.id);
        ihs.printLastThreeGuests();
        roomService.printRoomsSortedBy(RoomSortType.Stars);

        //services
        IServiceService serviceService = new ServiceService(new ServiceRepository());
        Service s1 = new Service("Prepare coffee", 1, 1);
        Service s2 = new Service("Prepare bacon and eggs", 4, 2);
        serviceService.addService(s1);
        serviceService.addService(s2);

        ihs.addServiceToGuest(g1, s1);
        ihs.addServiceToGuest(g1, s2);

        ihs.printServiceInfoForGuest(g1);
    }
}