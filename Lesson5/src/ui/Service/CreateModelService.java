package ui.Service;

import ui.controller.MainController;
import ui.menuItem.GuestMenuItem.GuestMenuItem;
import ui.menuItem.MainMenuItem;
import ui.menuItem.MenuItem;
import ui.menuItem.RoomMenuItem.RoomMenuItem;
import ui.menuItem.ServiceMenuItem.ServiceMenuItem;
import ui.model.ViewModel;

public class CreateModelService {
    private MainController mainController;

    public CreateModelService(MainController mainController){
        this.mainController=mainController;
    }

       public ViewModel createModelForMainMenu(){
           MenuItem item1=new MainMenuItem("Show Main Menu", mainController);
           MenuItem item2=new GuestMenuItem("Show guest menu",mainController);
           MenuItem item3=new RoomMenuItem("Show room menu", mainController);
           MenuItem item4=new ServiceMenuItem("ShowService menu",mainController);

           ViewModel viewModel= ViewModel.getModel("mainMenu");

           viewModel.addItem(item1);
           viewModel.addItem(item2);
           viewModel.addItem(item3);
           viewModel.addItem(item4);

           return viewModel;
       }



}
