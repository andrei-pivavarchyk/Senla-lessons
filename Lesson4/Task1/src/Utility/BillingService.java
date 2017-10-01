package Utility;

import Domain.Entities.GuestRoomInfo;

public class BillingService {
    public static int calculateGuestStaying(GuestRoomInfo guestInfo) {
        int days = DateService.getDaysDifference(guestInfo.getArrivalDate(), guestInfo.getDepartureDate());
        return days * guestInfo.getRoom().getCost();
    }
}