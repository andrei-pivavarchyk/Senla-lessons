package ui.View.guestView;


import entity.Guest;
import ui.Service.ConsoleService;
import ui.View.AbstractView;
import ui.menuItem.MenuItem;
import ui.model.ViewModel;

import java.util.ArrayList;

public class ShowAllGuestsSortedByDateView extends AbstractView {

    public ArrayList<Guest> allGuests;
    public ViewModel mainMenuViewModel;

    public ShowAllGuestsSortedByDateView(ArrayList<Guest> allGuests, ViewModel mainMenuViewModel){

        super(mainMenuViewModel);
        this.allGuests=allGuests;

    }

}
