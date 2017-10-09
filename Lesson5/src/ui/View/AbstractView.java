package ui.View;


import ui.Service.ConsoleService;
import ui.menuItem.Item;
import ui.model.ViewModel;

public class AbstractView {
    private ViewModel viewModel;

    public AbstractView(ViewModel viewModel) {

        this.viewModel=viewModel;
    }

    public void act()  {
        System.out.println(this.viewModel.getTitle());
        int i=1;
        for(Item item:viewModel.getMenuItems()){
            System.out.println(i+" "+item.getTitle());
            i++;
        }

        ConsoleService consoleService=ConsoleService.getConsoleService();
        int number=consoleService.getNumberForView(viewModel.getMenuItems().size());
        this.viewModel.getMenuItems().get(number-1).click();

    }
}
