package storeFactory;

import storage.IGuestStorage;

public abstract class AGuestStoreFactory {
    public abstract IGuestStorage createGuestStorage();
}
