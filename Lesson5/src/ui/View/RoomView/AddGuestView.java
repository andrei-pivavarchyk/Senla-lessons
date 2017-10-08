package ui.View.RoomView;


import entity.Guest;
import entity.Room;
import ui.Service.ConsoleService;
import ui.View.AbstractView;
import ui.menuItem.MenuItem;
import ui.model.ViewModel;

import java.util.List;
import java.util.Scanner;

public class AddGuestView extends AbstractView{
    private List<Room> allRooms;

    public AddGuestView(List<Room> allRooms, ViewModel model){
        super(model);
        this.allRooms=allRooms;

    }
    public void showInformation(){
        int i=1;
        for(Room room:allRooms){
            System.out.println(i+" "+room);
        }
    }

    public Room shooseRoom(){
System.out.println("Enter room Number");
        Scanner scanner1 = new Scanner(System.in);
        int roomNumber= scanner1.nextInt();
        for(Room room:allRooms){
            if(room.getNumber()==roomNumber){
                return room;
            }

        }
        return null;
    }

    public Guest createGuest(){
        System.out.print("Enter name");
        String name= ConsoleService.getConsoleService().getString();
        System.out.print("Enter surname");
        String surname= ConsoleService.getConsoleService().getString();
        Guest guest=new Guest(1,name,surname);
        return guest;

    }
}
