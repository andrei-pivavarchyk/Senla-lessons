package storeFactory;

import entity.Entity;
import storage.BaseStorage;
import storage.IBaseStorage;
import storage.IGuestStorage;

public abstract class AFactory<T extends IBaseStorage> {
    public abstract T createStorage();
}
