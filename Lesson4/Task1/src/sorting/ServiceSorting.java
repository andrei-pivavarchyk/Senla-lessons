package sorting;


import comparator.GuestDateComparator;
import comparator.ServiceCostComparator;
import comparator.ServiceDateComparator;
import entity.Guest;
import guestService.Service;

import java.util.ArrayList;

public class ServiceSorting {


    public static ArrayList serviceCostSorting(ArrayList<Service> listOfServices){

        ArrayList<Service> copyArray= new ArrayList<Service>(listOfServices);
        copyArray.sort(new ServiceCostComparator());
        return copyArray;
    }

    public static ArrayList serviceDateSorting(ArrayList<Service> listOfServices){
        ArrayList<Service> copyArray= new ArrayList<Service>(listOfServices);
        copyArray.sort(new ServiceDateComparator());
        return copyArray;
    }


}
