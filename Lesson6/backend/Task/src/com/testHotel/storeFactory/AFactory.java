package com.testHotel.storeFactory;

import com.testHotel.storage.IBaseStorage;

public abstract class AFactory<T extends IBaseStorage> {
    public abstract T createStorage();
}
