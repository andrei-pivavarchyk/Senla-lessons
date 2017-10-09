package ui.View.guestView;


import entity.Guest;
import ui.View.AbstractView;
import ui.model.ViewModel;

import java.util.ArrayList;

public class ShowAllGuestsView extends AbstractView{

   private ArrayList<Guest> allGuests;



    public ShowAllGuestsView(ArrayList<Guest> allGuests, ViewModel mainMenuViewModel){
        super(mainMenuViewModel);
        this.allGuests=allGuests;

    }

public void showInformation(){

    System.out.println("INFORMATION***INFORMATION***INFORMATION***INFORMATION");
    for(Guest guest:allGuests){
        System.out.println(guest);
    }
}
}


