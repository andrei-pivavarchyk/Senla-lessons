package ui.storeFactory;


import Storage.IRoomStorage;
import Storage.RoomStorage;
import ui.controller.AController;
import ui.controller.MainController;

public class RoomStoreFactory extends ARoomStoreFactory {

    public IRoomStorage createRoomStorage(){

        IRoomStorage roomStorage=new RoomStorage();
        return roomStorage;

    }

}
