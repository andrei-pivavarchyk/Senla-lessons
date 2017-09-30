package Domain.Services;

import Comparator.GuestInfoNameComparator;
import DataLayer.RoomRepository;
import Domain.Contracts.IRoomRepository;
import Domain.Entities.*;
import Services.BillingService;
import Services.Literals;
import Sorting.GuestInfoSortType;

import java.util.ArrayList;
import java.util.Date;

public class RoomService implements IRoomService {
    private ArrayList<RoomGuestInfo> guestsInfo = new ArrayList<>();
    private IRoomRepository roomRepository;

    private int getCurrenGuestCount(Room room) {
        int count = 0;
        for (RoomGuestInfo gi : guestsInfo) {
            if (gi.getRoom().equals(room) && gi.getStillLiving()) {
                count++;
            }
        }

        return count;
    }

    public void checkInGuest(Room room, Guest guest, Date arrivalDate, Date departureDate) {
        if (!(room.getCurrentGuestCount() < room.getCapacity())) {
            System.out.println(new StringBuilder(Literals.roomNoFreePlaces).append("in Entity.Room"));
        }


        RoomGuestInfo gi = new RoomGuestInfo(arrivalDate, departureDate, guest, room);
        room.setStatus(RoomStatus.reserved);
        guestsInfo.add(gi);
    }

    public void checkOutGuest(Room room, Guest guest) {
        room.removeGuest(guest);
    }

    public void PrintGuestsSortedBy(GuestInfoSortType guestsSortType) {
        ArrayList<RoomGuestInfo> guests = new ArrayList<>();
        for (RoomGuestInfo gi : guestsInfo) {
            if (gi.getStillLiving()) {
                guests.add(gi);
            }
        }

        PrintGuests(SortGuestsBy(guests, guestsSortType), "Guests sorted by " + guestsSortType.toString() + ":");
    }

    public ArrayList<Room> getRoomsCountFreedByDate(Date date) {
        ArrayList<Room> freeRoomsByDate = new ArrayList<>();

        for (RoomGuestInfo gi : guestsInfo) {
            if (gi.getStillLiving()) {
                if (gi.getDepartureDate().compareTo(date) == -1) {
                    freeRoomsByDate.add(gi.getRoom());
                }
            }
        }

        //TODO: decide whose responsibility it is (return count + (this.capacity - getCurrenGuestCount());)
        return freeRoomsByDate;
    }

    public void getPaymentForGuest() {
        int price = BillingService.calculateGuestStaying(guestsInfo.get(0));
        System.out.println("Price: " + price);
    }

    public ArrayList<Guest> getLastThreeGuests() {
        ArrayList<Guest> lastThreeGuests = new ArrayList<>();
        for (int i = guestsInfo.size(), k = 0; i > 0 && k < 3; i--, k++) {
            Guest guest = guestsInfo.get(i - 1).getGuest();
            System.out.println(guest + guestsInfo.get(i - 1).getDepartureDate().toString());
        }

        return lastThreeGuests;
    }

    private ArrayList<RoomGuestInfo> SortGuestsBy(ArrayList<RoomGuestInfo> guests, GuestInfoSortType guestSortType) {
        switch (guestSortType) {
            case Name:
                guests.sort(new GuestInfoNameComparator());
                return guests;
            default:
                return null;
        }
    }

    private void PrintGuests(ArrayList<RoomGuestInfo> guests, String message) {
        System.out.println(message);
        for (RoomGuestInfo gi : guests) {
            System.out.println(gi);
        }
    }
}