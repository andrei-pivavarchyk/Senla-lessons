package ui.View.guestView;


import entity.Guest;
import sun.security.x509.AVA;
import ui.Service.ConsoleService;
import ui.View.AbstractView;
import ui.menuItem.MenuItem;
import ui.model.ViewModel;

import java.util.ArrayList;

public class ShowAllGuestsView extends AbstractView{

   private ArrayList<Guest> allGuests;



    public ShowAllGuestsView(ArrayList<Guest> allGuests, ViewModel mainMenuViewModel){
        super(mainMenuViewModel);
        this.allGuests=allGuests;

    }



}
