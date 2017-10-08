package ui.View;


import ui.Service.ConsoleService;
import ui.menuItem.MenuItem;
import ui.model.ViewModel;

import java.lang.reflect.InvocationTargetException;

public class AbstractView {
    private ViewModel viewModel;

    public AbstractView(ViewModel viewModel) {

        this.viewModel=viewModel;
    }

    public void act()  {
        System.out.println(this.viewModel.getTitle());
        int i=1;
        for(MenuItem menuItem:viewModel.getMenuItems()){
            System.out.println(i+" "+menuItem.title);
            i++;
        }

        ConsoleService consoleService=ConsoleService.getConsoleService();
        int number=consoleService.getNumberForView(viewModel.getMenuItems().size());
        this.viewModel.getMenuItems().get(number-1).click();

    }
}
