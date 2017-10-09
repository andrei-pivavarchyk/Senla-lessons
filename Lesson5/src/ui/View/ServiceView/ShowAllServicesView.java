package ui.View.ServiceView;

import entity.Service;
import ui.View.AbstractView;
import ui.model.ViewModel;


import java.util.ArrayList;


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
