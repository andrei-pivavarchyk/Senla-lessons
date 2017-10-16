package storeFactory;


import storage.GuestStorage;
import storage.IBaseStorage;
import storage.IGuestStorage;

public class GuestStoreFactory extends AGuestStoreFactory{
    @Override
    public IGuestStorage createGuestStorage() {
        IGuestStorage guestStorage=new GuestStorage();
        return guestStorage;
    }
}
