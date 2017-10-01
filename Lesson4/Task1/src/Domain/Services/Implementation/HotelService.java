package Domain.Services.Implementation;

import Domain.Contracts.IGuestRoomInfoRepository;
import Domain.Contracts.IGuestServiceInfoRepository;
import Domain.Entities.*;
import Domain.Services.Contracts.IHotelService;
import Domain.Services.Contracts.IRoomService;
import Sorting.GuestInfoSortType;
import Sorting.RoomSortType;
import Utility.BillingService;
import Utility.Literals;
import Utility.PrintOperationsService;

import java.util.ArrayList;
import java.util.Date;

public class HotelService implements IHotelService {
    private IRoomService roomService;
    private IGuestRoomInfoRepository guestRoomInfoRepository;
    private IGuestServiceInfoRepository guestServiceInfoRepository;

    public HotelService(
            IRoomService roomService,
            IGuestRoomInfoRepository guestRoomInfoRepository,
            IGuestServiceInfoRepository guestServiceInfoRepository) {
        this.roomService = roomService;
        this.guestRoomInfoRepository = guestRoomInfoRepository;
        this.guestServiceInfoRepository = guestServiceInfoRepository;
    }

    @Override
    public void checkInGuest(Room room, Guest guest, Date arrivalDate, Date departureDate) {
        //TODO think about possibility to limit adding a guest to a room where he's currently living
        if (!(room.getCurrentNumberOfGuests() < room.getCapacity())) {
            System.out.println(Literals.roomNoFreePlaces);
        }

        GuestRoomInfo gi = new GuestRoomInfo(arrivalDate, departureDate, guest, room);
        gi.setIsStillLiving(true);
        room.setStatus(RoomStatus.reserved);
        room.setCurrentNumberOfGuests(room.getCurrentNumberOfGuests() + 1);
        guestRoomInfoRepository.Create(gi);
    }

    @Override
    public void checkOutGuest(Room room, Guest guest) {
        for (GuestRoomInfo gri : guestRoomInfoRepository.Fetch()) {
            if (gri.getGuest() == guest && gri.getRoom() == room && gri.getStillLiving()) {
                gri.setIsStillLiving(false);
                room.setCurrentNumberOfGuests(room.getCurrentNumberOfGuests() - 1);
            }
        }
    }

    @Override
    public void printCurrentLivingGuestsSortedBy(GuestInfoSortType guestsSortType) {
        ArrayList<GuestRoomInfo> guests = new ArrayList<>();
        for (GuestRoomInfo gi : guestRoomInfoRepository.Fetch()) {
            if (gi.getStillLiving()) {
                guests.add(gi);
            }
        }

        PrintOperationsService.PrintGuests(PrintOperationsService.SortGuestsBy(guests, guestsSortType),
                "Guests sorted by " + guestsSortType.toString() + ":");
    }

    @Override
    public int getCurrentLivingGuestsCount() {
        int count = 0;
        for (GuestRoomInfo gri : guestRoomInfoRepository.Fetch()) {
            if (gri.getStillLiving() == true) {
                count += gri.getRoom().getCurrentNumberOfGuests();
            }
        }

        return count;
    }

    @Override
    public void printFreeRoomsByDate(Date date) {
        //we need to select rooms that are not empty and make selection distinct
        ArrayList<Room> freeRoomsByDate = new ArrayList<>();

        for (GuestRoomInfo gi : guestRoomInfoRepository.Fetch()) {
            if (gi.getStillLiving()) {
                if (gi.getDepartureDate().compareTo(date) == -1) {
                    if (!freeRoomsByDate.contains(gi)) {
                        freeRoomsByDate.add(gi.getRoom());
                    }
                }
            }
        }

        freeRoomsByDate.addAll(roomService.getFreeRooms());
        PrintOperationsService.PrintRooms(PrintOperationsService.SortRoomsBy(freeRoomsByDate,
                RoomSortType.Capacity), "Rooms free by date:");
    }

    @Override
    public void getPaymentForGuest(int guestId) {
        for (GuestRoomInfo gi : guestRoomInfoRepository.Fetch()) {
            if (gi.getStillLiving()) {
                if (gi.getGuest().id == guestId) {
                    int price = BillingService.calculateGuestStaying(gi);
                    System.out.println("Price: " + price);
                }
            }
        }
    }

    @Override
    public void printLastThreeGuests() {
        ArrayList<GuestRoomInfo> lastThreeGuests = new ArrayList<>();
        for (int i = guestRoomInfoRepository.Fetch().size(), k = 0; i > 0 && k < 3; i--, k++) {
            lastThreeGuests.add(guestRoomInfoRepository.Fetch().get(i - 1));
        }

        PrintOperationsService.PrintGuestsDepartureDates(lastThreeGuests, "Last three guests: ");
    }

    @Override
    public void addServiceToGuest(Guest guest, Service service) {
        guestServiceInfoRepository.Create(new GuestServiceInfo(guest, service, new Date(), false));
    }

    @Override
    public void printServiceInfoForGuest(Guest guest) {
        System.out.println("Services for guests:");
        for (GuestServiceInfo sgi : guestServiceInfoRepository.Fetch()) {
            if (sgi.getGuest().equals(guest)) {
                System.out.println(sgi);
            }
        }
    }
}