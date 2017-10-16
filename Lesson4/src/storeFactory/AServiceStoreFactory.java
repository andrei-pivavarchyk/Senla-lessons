package storeFactory;

import storage.IServiceStorage;

public abstract class AServiceStoreFactory {
    public abstract IServiceStorage createServiceStorage();
}
