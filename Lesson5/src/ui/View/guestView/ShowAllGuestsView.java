package ui.View.guestView;


import entity.Guest;
import ui.Service.ConsoleService;
import ui.menuItem.MenuItem;
import ui.model.ViewModel;

import java.util.ArrayList;

public class ShowAllGuestsView {

    public String title="ShowAllGuests";
    public ArrayList<Guest> allGuests;
    public ViewModel mainMenuViewModel;


    public ShowAllGuestsView(ArrayList<Guest> allGuests, ViewModel mainMenuViewModel){
        this.title=title;
        this.allGuests=allGuests;
        this.mainMenuViewModel=mainMenuViewModel;
    }




    public void act(){
        System.out.println(mainMenuViewModel.title);
        int i=1;
        for(MenuItem menuItem:mainMenuViewModel.menuItems){
            System.out.println(i+" "+menuItem.title);
            i++;
        }

        ConsoleService consoleService=new ConsoleService();
        int number=consoleService.getNumber(mainMenuViewModel.getMenuItems().size());
        this.mainMenuViewModel.menuItems.get(number-1).click();

    }
}
