package hotel.storeFactory;

import hotel.storage.GuestStorage;
import hotel.storage.IGuestStorage;

public class GuestStoreFactory extends AFactory<IGuestStorage>{
    @Override
    public IGuestStorage createStorage() {
        IGuestStorage guestStorage=new GuestStorage();
        return guestStorage;
    }
}
