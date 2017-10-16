package storeFactory;


import storage.IRoomStorage;

public abstract class ARoomStoreFactory {
    public abstract IRoomStorage createRoomStorage();
}
