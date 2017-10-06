package ui.View;


import ui.Service.ConsoleService;
import ui.menuItem.MenuItem;
import ui.model.ViewModel;

public class AbstractView {
    private ViewModel mainMenuViewModel;

    public AbstractView(ViewModel mainMenuViewModel) {
        this.mainMenuViewModel=mainMenuViewModel;
    }

    public void act(){
        System.out.println(mainMenuViewModel.title);
        int i=1;
        for(MenuItem menuItem:mainMenuViewModel.menuItems){
            System.out.println(i+" "+menuItem.title);
            i++;
        }

        ConsoleService consoleService=new ConsoleService();
        int number=consoleService.getNumber(mainMenuViewModel.getMenuItems().size());
        this.mainMenuViewModel.menuItems.get(number-1).click();

    }
}
