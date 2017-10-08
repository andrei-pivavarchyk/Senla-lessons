package ui.storeFactory;

import Storage.GuestStorage;
import Storage.IGuestStorage;
import Storage.IServiceStorage;
import Storage.ServiceStorage;


public class GuestStoreFactory extends AGuestStoreFactory {

    public IGuestStorage createGuestStorage(){

        IGuestStorage guestStorage=new GuestStorage();
        return guestStorage;

    }
}
