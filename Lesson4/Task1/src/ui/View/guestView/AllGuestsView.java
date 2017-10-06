package ui.View.guestView;


import entity.Guest;

import java.util.ArrayList;

public class AllGuestsView {

    public String title="ShowAllGuests";
    public ArrayList<Guest> allGuests;


    public AllGuestsView (ArrayList<Guest> allGuests){
        this.title=title;
        this.allGuests=allGuests;
    }

    public void act(){

        for(Guest guest:this.allGuests){
            System.out.println(guest);
        }
        System.out.println("All guests was printed");
    }
}
