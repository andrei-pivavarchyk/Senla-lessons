package ui.storeFactory;

import Storage.IGuestStorage;
import Storage.IServiceStorage;

public abstract class AServiceStoreFactory{

    public abstract IServiceStorage createServiceStorage();
}
