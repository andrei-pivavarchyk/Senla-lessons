import DataLayer.GuestRoomInfoRepository;
import DataLayer.GuestServiceInfoRepository;
import DataLayer.HotelRepository;
import DataLayer.RoomRepository;
import Domain.Contracts.IHotelRepository;
import Domain.Contracts.IRoomRepository;
import Domain.Entities.Guest;
import Domain.Entities.Hotel;
import Domain.Entities.Room;
import Domain.Entities.Service;
import Domain.Services.*;
import Sorting.GuestInfoSortType;
import Sorting.RoomSortType;
import Utility.EntityReader;

import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        //service:
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
                irr), new GuestRoomInfoRepository());
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
    }

    private static void BuildObjects() {
        IHotelRepository hr = new HotelRepository();
        IRoomRepository rr = new RoomRepository();

        Hotel h = new Hotel("Renessence", 1, new RoomService(new GuestRoomInfoRepository(), new RoomRepository()));
        hr.Create(h);
        System.out.println(hr.Read(1));
        h.setName("Hotel 2");
        hr.Update(h);
        System.out.println(hr.Read(1));

        ServiceService ss = new ServiceService(new GuestServiceInfoRepository());
        Guest g = new Guest("Jade", "Stamm", 2);
        ss.addServiceToGuest(g, new Service("Jakuzi", 232));
        ss.printServiceInfoForGuest(g);
    }

    private static void Perform() {
        Hotel bestHotel = new Hotel("bestHotel", 2, new RoomService(new GuestRoomInfoRepository(), new RoomRepository()));
        RoomService rs = new RoomService(new GuestRoomInfoRepository(), new RoomRepository());
        ServiceService ss = new ServiceService(new GuestServiceInfoRepository());
        IHotelService hs = new HotelService(new RoomService(new GuestRoomInfoRepository(),
                new RoomRepository()), new GuestRoomInfoRepository());
        ArrayList<Room> newRooms = EntityReader.readRoomsFromFile();
        Room r1 = newRooms.get(2);
/*        for (Room r : newRooms) {
            hs.addRoom(r);
        }*/

        //1:
/*      hs.PrintFreeRoomsSortedBy(RoomSortType.Cost);
        hs.PrintFreeRoomsSortedBy(RoomSortType.Capacity);
        hs.PrintFreeRoomsSortedBy(RoomSortType.Stars);*/

        //2:
/*      hs.PrintRoomsSortedBy(RoomSortType.Cost);
        hs.PrintRoomsSortedBy(RoomSortType.Capacity);
        hs.PrintRoomsSortedBy(RoomSortType.Stars);*/

        //3:
        /*rs.PrintGuestsSortedBy(RoomGuestInfoSortType.Name);*/

        //4
        /*System.out.println("Number of free rooms:" + hs.getFreeRoomsCount());*/

        //5
        /*System.out.println("Number of guests:" + hs.getGuestsCount());*/

        //6
        /*hs.printFreeRoomsByDate(new Date(2019,1,2));*/

        //7
/*        Guest g1 = new Guest("Jack", "Daniels", 1);
        Guest g2 = new Guest("Mack", "Janiels", 2);
        Guest g3 = new Guest("Back", "Raniels", 3);
        rs.checkInGuest(r1, g1, new Date(2017, 1, 2), new Date(2017, 1, 3));
        rs.checkInGuest(r1, g2, new Date(2017, 1, 2), new Date(2017, 1, 3));
        rs.checkInGuest(r1, g3, new Date(2017, 1, 2), new Date(2017, 1, 3));
        rs.getPaymentForGuest(g1.id);

        //8 - move logic to hotel service
        rs.getLastThreeGuests();

        //
        ss.addServiceToGuest(g1, new Service("Spa", 2000));
        ss.printServiceInfoForGuest(g1);*/
    }
}