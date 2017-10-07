package ui.controller;


import ui.Service.CreateModelService;
import ui.View.MainMenuView;
import ui.model.ViewModel;

public class MainController {
    private CreateModelService modelService;
    public MainController(){
        this.modelService=new CreateModelService(this);
    }


    public void showMainMenu(){
        ViewModel model=this.modelService.createModelForMainMenu();
        MainMenuView view=new MainMenuView(model);
        view.act();
    }

}
