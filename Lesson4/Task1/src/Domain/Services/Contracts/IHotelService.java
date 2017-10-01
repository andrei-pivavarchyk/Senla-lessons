package Domain.Services.Contracts;

import Domain.Entities.Guest;
import Domain.Entities.Room;
import Domain.Entities.Service;
import Sorting.GuestInfoSortType;

import java.util.Date;

public interface IHotelService {

    void checkInGuest(Room room, Guest guest, Date arrivalDate, Date departureDate);

    void checkOutGuest(Room room, Guest guest);

    void printCurrentLivingGuestsSortedBy(GuestInfoSortType guestsSortType);

    int getCurrentLivingGuestsCount();

    void printFreeRoomsByDate(Date date);

    void getPaymentForGuest(int guestId);

    void printLastThreeGuests();

    void addServiceToGuest(Guest guest, Service service);

    void printServiceInfoForGuest(Guest guest);
}
