package ui.View.RoomView;


import entity.Room;
import ui.View.AbstractView;
import ui.model.ViewModel;

import java.util.List;

public class ShowRoomsView extends AbstractView{
    private List<Room> allRooms;

    public ShowRoomsView(List<Room> allRooms, ViewModel mainMenuViewModel){
        super(mainMenuViewModel);
        this.allRooms=allRooms;

    }
    public void showInformation(){
        System.out.println("INFORMATION***INFORMATION***INFORMATION***INFORMATION");
        for(Room room:allRooms){
            System.out.println(room);
        }
    }
}
