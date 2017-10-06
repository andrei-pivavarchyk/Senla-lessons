package ui.View.guestView;
import ui.Service.ConsoleService;
import ui.View.IView;
import ui.model.ViewModel;
import ui.menuItem.MenuItem;


public class GuestMenuView implements IView{

    private ViewModel mainMenuViewModel;

    public GuestMenuView(ViewModel mainMenuViewModel){

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
