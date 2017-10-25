package com.testHotel.storeFactory;


import com.testHotel.storage.IRoomStorage;
import com.testHotel.storage.RoomStorage;

public class RoomStoreFactory extends AFactory<IRoomStorage>{
    @Override
    public IRoomStorage createStorage() {
        IRoomStorage roomStorage=new RoomStorage();
        return roomStorage;
    }
}
