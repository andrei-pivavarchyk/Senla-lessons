package ui.View.RoomView;


import entity.Room;
import ui.View.AbstractView;
import ui.model.ViewModel;

import java.util.List;

public class ShowAllRoomsSortedByCostView extends AbstractView{
    private List<Room> allRooms;

    public ShowAllRoomsSortedByCostView(List<Room> allRooms, ViewModel mainMenuViewModel){
        super(mainMenuViewModel);
        this.allRooms=allRooms;

    }
    public void showInformation(){
        for(Room room:allRooms){
            System.out.println(room);
        }
    }
}
