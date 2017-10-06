package ui.View;

import ui.Service.ConsoleService;
import ui.model.ViewModel;
import ui.model.menuItem.MenuItem;


public class MainMenuView implements IView{
    private ViewModel mainMenuViewModel;

    public MainMenuView(ViewModel mainMenuViewModel){

        this.mainMenuViewModel=mainMenuViewModel;
    }

    public void act(){
        System.out.println(mainMenuViewModel.title);
        for(MenuItem menuItem:mainMenuViewModel.menuItems){
            System.out.println(menuItem.id+" "+menuItem.title);
        }

        ConsoleService consoleService=new ConsoleService();
        int number=consoleService.getNumber(mainMenuViewModel.getMenuItems().size());
        this.mainMenuViewModel.menuItems.get(number-1).click();

    }


    public void startAnoyherView(int number){}

    public ViewModel getMainMenuViewModel() {
        return mainMenuViewModel;
    }
}
