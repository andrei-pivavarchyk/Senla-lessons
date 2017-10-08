package ui.Service;

import ui.controller.MainController;
import ui.menuItem.GuestMenuItem.GuestMenuItem;
import ui.menuItem.Item;
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


        Item item1=new Item("Show Main Menu", mainController,method1);
        Item item2=new Item("showMainMenu",mainController,method1);
        Item item3=new Item("Show room menu", mainController,method1);
        Item item4=new Item("ShowService menu",mainController,method1);

        ViewModel viewModel= ViewModel.getModel("mainMenu");

        viewModel.addItem(item1);
        viewModel.addItem(item2);
        viewModel.addItem(item3);
        viewModel.addItem(item4);

        return viewModel;
    }



}
