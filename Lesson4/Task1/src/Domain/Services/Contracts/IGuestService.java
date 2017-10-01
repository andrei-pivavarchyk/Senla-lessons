package Domain.Services.Contracts;

import Domain.Entities.Guest;

public interface IGuestService {
    void addGuest(Guest guest);

    void removeGuest(Guest guest);
}
