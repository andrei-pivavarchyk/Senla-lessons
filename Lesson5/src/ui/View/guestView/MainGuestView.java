package ui.View.guestView;
import ui.Service.ConsoleService;
import ui.View.IView;
import ui.model.ViewModel;
import ui.model.menuItem.MenuItem;


public class MainGuestView  implements IView{

    private ViewModel mainMenuViewModel;

    public MainGuestView(ViewModel mainMenuViewModel){

        this.mainMenuViewModel=mainMenuViewModel;
    }
    public void act(){
        System.out.println(mainMenuViewModel.title);
        for(MenuItem menuItem:mainMenuViewModel.menuItems){
            System.out.println(menuItem.id+" "+menuItem.title);
        }
        ConsoleService consoleService=new ConsoleService();
        consoleService.getNumber(mainMenuViewModel.getMenuItems().size());
    }

    public void startAnoyherView(int number){
        System.out.print(600);
    }
}
