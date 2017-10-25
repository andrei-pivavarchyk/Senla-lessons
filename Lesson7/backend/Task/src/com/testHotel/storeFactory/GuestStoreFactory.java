package com.testHotel.storeFactory;

import com.testHotel.storage.IGuestStorage;
import com.testHotel.storage.GuestStorage;

public class GuestStoreFactory extends AFactory<IGuestStorage>{
    @Override
    public IGuestStorage createStorage() {
        IGuestStorage guestStorage=new GuestStorage();
        return guestStorage;
    }
}
