package Services;

import Domain.Entities.RoomGuestInfo;

public class BillingService {
    public static int calculateGuestStaying(RoomGuestInfo guestInfo) {
        int days = DateService.getDaysDifference(guestInfo.getArrivalDate(), guestInfo.getDepartureDate());
        return days * guestInfo.getRoom().getCost();
    }
}