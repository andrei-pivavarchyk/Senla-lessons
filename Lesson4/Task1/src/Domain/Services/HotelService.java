package Domain.Services;

import Comparator.GuestInfoNameComparator;
import Comparator.RoomCapacityCorporator;
import Comparator.RoomCostComparator;
import Comparator.RoomStarsComparator;
import Domain.Contracts.IHotelRepository;
import Domain.Entities.*;
import Services.BillingService;
import Services.Literals;
import Sorting.GuestInfoSortType;
import Sorting.RoomSortType;

import java.util.ArrayList;
import java.util.Date;

public class HotelService implements IHotelService {
    private Hotel hotel;
    private IRoomService roomService;

    public HotelService(IHotelRepository hotelRepository, IRoomService roomService) {
        this.hotel = hotelRepository.Read(1);
        this.roomService = roomService;
    }

    @Override
    public void PrintRoomsSortedBy(RoomSortType roomSortType) {
        ArrayList<Room> copiedArray = new ArrayList<>(hotel.getRooms());
        PrintRooms(SortRoomsBy(copiedArray, roomSortType), "Rooms sorted by " + roomSortType.toString() + ":");
    }

    @Override
    public void PrintFreeRoomsSortedBy(RoomSortType roomSortType) {
        ArrayList<Room> copiedArray = new ArrayList<>(getFreeRooms());
        PrintRooms(SortRoomsBy(copiedArray, roomSortType), "Rooms sorted by " + roomSortType.toString() + ":");
    }

    @Override
    public int getRoomsCount() {
        return hotel.getRooms().size();
    }

    @Override
    public int getFreeRoomsCount() {
        return getFreeRooms().size();
    }

    @Override
    public int getGuestsCount() {
        return hotel.getGuests().size();
    }

    @Override
    public void addRoom(Room room) {
        hotel.getRooms().add(room);
    }

    @Override
    public void removeRoom(Room room) {
        if (hotel.getRooms().contains(room)) {
            hotel.getRooms().remove(room);
        } else {
            System.out.println(Literals.guestNotFoundInRoom);
        }
    }

    @Override
    public void printFreeRoomsByDate(Date date) {
        ArrayList<Room> freeRoomsByDate = new ArrayList<>();
        freeRoomsByDate.addAll(getFreeRooms());
        freeRoomsByDate.addAll(roomService.getRoomsCountFreedByDate(date));
        PrintRooms(SortRoomsBy(freeRoomsByDate, RoomSortType.Capacity), "Rooms free by date:");
    }

    @Override
    public void addGuestToRoom(int roomNumber, Guest guest, int year, int month, int day) {
        //NOT IMPLEMENTED YET
    }

    @Override
    public void getRoomDetails(Room room) {
        System.out.println(room);
    }

    private ArrayList<Room> getFreeRooms() {
        ArrayList<Room> freeRooms = new ArrayList<>();
        for (Room r : hotel.getRooms()) {
            if (r.getStatus().equals(RoomStatus.free)) {
                freeRooms.add(r);
            }
        }

        return freeRooms;
    }

    private ArrayList<Room> SortRoomsBy(ArrayList<Room> rooms, RoomSortType roomSortType) {
        switch (roomSortType) {
            case Cost:
                rooms.sort(new RoomCostComparator());
                return rooms;
            case Capacity:
                rooms.sort(new RoomCapacityCorporator());
                return rooms;
            case Stars:
                rooms.sort(new RoomStarsComparator());
                return rooms;
            default:
                return null;
        }
    }

    private void PrintRooms(ArrayList<Room> rooms, String message) {
        System.out.println(message);
        for (Room r : rooms) {
            System.out.println(r);
        }
    }

    public static class RoomService implements IRoomService {
        private ArrayList<RoomGuestInfo> guestsInfo = new ArrayList<>();

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
                System.out.println(new StringBuilder(Literals.roomNoFreePlaces).append("in Domain.Entities.Room"));
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
            ArrayList<Guest> lastThreeGuests = new ArrayList<Guest>();
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
}