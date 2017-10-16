package storeFactory;

import storage.GuestStorage;
import storage.IGuestStorage;

public class GuestStoreFactory extends AFactory<IGuestStorage>{
    @Override
    public IGuestStorage createStorage() {
        IGuestStorage guestStorage=new GuestStorage();
        return guestStorage;
    }
}
