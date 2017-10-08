package ui.menuItem.ServiceMenuItem;


import ui.controller.MainController;
import ui.menuItem.MenuItem;


public class ShowAllServicesSortedByType extends MenuItem{
    public ShowAllServicesSortedByType( String title, MainController mainController) {
        super( title, mainController);
    }
    public void click(){
        this.mainController.showAllGuestsMenu();
    }
}
