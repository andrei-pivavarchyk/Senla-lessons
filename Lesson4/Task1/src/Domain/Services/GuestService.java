package Domain.Services;

import Domain.Contracts.IGuestRepository;

public class GuestService {
    private IGuestRepository guestRepository;

    public GuestService(IGuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }
}
