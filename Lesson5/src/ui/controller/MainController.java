package ui.controller;


import ui.Service.ModelCreationService;
import ui.View.MainMenuView;
import ui.model.ViewModel;

import java.lang.reflect.InvocationTargetException;

public class MainController {
    private ModelCreationService modelService;
    public MainController(){
        this.modelService=new ModelCreationService(this);
    }




    public void showMainMenu()  {
        ViewModel model=this.modelService.createModelForMainMenu();
        MainMenuView view=new MainMenuView(model);
        view.act();
    }

    public void showRoomMenu(){}

    public void showGuestMenu(){}

    public void showServiceMenu(){}

    public void showAllGuestsMenu(){}

    public void showAllGuestsSortedByDepartureDateMenu(){}







}
