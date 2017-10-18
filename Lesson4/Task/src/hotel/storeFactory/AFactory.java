package hotel.storeFactory;

import hotel.storage.IBaseStorage;

public abstract class AFactory<T extends IBaseStorage> {
    public abstract T createStorage();
}
