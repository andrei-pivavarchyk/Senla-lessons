package ui.Service;

import ui.controller.MainController;
import ui.menuItem.GuestMenuItem.GuestMenuItem;
import ui.menuItem.MainMenuItem;
import ui.menuItem.MenuItem;
import ui.menuItem.RoomMenuItem.RoomMenuItem;
import ui.menuItem.ServiceMenuItem.ServiceMenuItem;
import ui.model.ViewModel;

import java.lang.reflect.Method;

public class ModelCreationService {
    private MainController mainController;

    public ModelCreationService(MainController mainController){
        this.mainController=mainController;
    }

    public ViewModel createModelForMainMenu(){

        Method method1=ReflectionService.getReflectionService().getMethod(mainController,"showMainMenu");
        Method method2=ReflectionService.getReflectionService().getMethod(mainController,"showMainMenu");
        Method method3=ReflectionService.getReflectionService().getMethod(mainController,"showMainMenu");
        Method method4=ReflectionService.getReflectionService().getMethod(mainController,"showMainMenu");


        MenuItem item1=new MainMenuItem("Show Main Menu", mainController);
        MenuItem item2=new GuestMenuItem("showMainMenu",mainController);
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
