package ui.storeFactory;

import Storage.IGuestStorage;
import Storage.IRoomStorage;


public abstract class AGuestStoreFactory {
    public abstract IGuestStorage createGuestStorage();
}
