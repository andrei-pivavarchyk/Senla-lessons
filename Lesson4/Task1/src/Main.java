import DataLayer.HotelRepository;
import DataLayer.RoomRepository;
import Domain.Contracts.IHotelRepository;
import Domain.Contracts.IRoomRepository;
import Domain.Entities.Guest;
import Domain.Entities.Hotel;
import Domain.Entities.Room;
import Domain.Entities.Service;
import Domain.Services.HotelService;
import Domain.Services.IHotelService;
import Domain.Services.IRoomService;
import Domain.Services.RoomService;
import Services.ServiceService;

import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        IHotelRepository hr = new HotelRepository();
        IRoomRepository rr = new RoomRepository();

        Hotel h = new Hotel("Renessence", 1);
        hr.Create(h);
        System.out.println(hr.Read(1));
        h.setName("Hotel 2");
        hr.Update(h);
        System.out.println(hr.Read(1));
    }

    private static void Perform() {
        Hotel bestHotel = new Hotel("bestHotel", 2);
        HotelService.RoomService rs = new HotelService.RoomService();
        ServiceService ss = new ServiceService();
        IHotelService hs = new HotelService(new HotelRepository(), new RoomService());
        ArrayList<Room> newRooms = IRoomService.readRoomsFromFile();
        Room r1 = newRooms.get(2);
        for (Room r : newRooms) {
            hs.addRoom(r);
        }

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
        Guest g1 = new Guest("Jack", "Daniels", 1);
        Guest g2 = new Guest("Mack", "Janiels", 2);
        Guest g3 = new Guest("Back", "Raniels", 3);
        rs.checkInGuest(r1, g1, new Date(2017, 1, 2), new Date(2017, 1, 3));
        rs.checkInGuest(r1, g2, new Date(2017, 1, 2), new Date(2017, 1, 3));
        rs.checkInGuest(r1, g3, new Date(2017, 1, 2), new Date(2017, 1, 3));
        rs.getPaymentForGuest();

        //8 - move logic to hotel service
        rs.getLastThreeGuests();

        //
        ss.addServiceToGuest(g1, new Service("Spa", 2000));
        ss.printServiceInfoForGuest(g1);
    }
}