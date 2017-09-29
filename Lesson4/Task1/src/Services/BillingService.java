package Services;

import Entity.GuestInfo;

import java.util.Date;

public class BillingService {
    public static int calculateGuestStaying(GuestInfo guestInfo) {
        int days = DateService.getDaysDifference(guestInfo.getArrivalDate(), guestInfo.getDepartureDate());
        return days * guestInfo.getRoom().getCost();
    }
}