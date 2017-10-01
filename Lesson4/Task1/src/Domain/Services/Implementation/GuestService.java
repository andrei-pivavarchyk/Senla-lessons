package Domain.Services.Implementation;

import Domain.Contracts.IGuestRepository;
import Domain.Entities.Guest;
import Domain.Services.Contracts.IGuestService;

public class GuestService implements IGuestService {
    private IGuestRepository guestRepository;

    public GuestService(IGuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @Override
    public void addGuest(Guest guest) {
        guestRepository.Create(guest);
    }

    @Override
    public void removeGuest(Guest guest) {
        guestRepository.Delete(guest.id);
    }
}