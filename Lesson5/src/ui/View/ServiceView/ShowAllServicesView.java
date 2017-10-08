package ui.View.ServiceView;

import entity.Guest;
import ui.Service.ConsoleService;
import ui.View.AbstractView;
import ui.menuItem.MenuItem;
import ui.model.ViewModel;

import javax.xml.ws.Service;
import java.util.ArrayList;
import java.util.List;


public class ShowAllServicesView extends AbstractView {

    private ViewModel mainMenuViewModel;
    private ArrayList<Service> allServices;

    public ShowAllServicesView(ArrayList<Service> allServices, ViewModel mainMenuViewModel) {
        super(mainMenuViewModel);
        this.allServices = allServices;
    }

    public void showInformation() {

        System.out.println("INFORMATION***INFORMATION***INFORMATION***INFORMATION");
        for (Service service : allServices) {
            System.out.println(service);
        }
    }
}
