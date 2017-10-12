package comparator;

import entity.Service;

import java.util.Comparator;

public class ServiceCostComparator implements Comparator<Service> {


    @Override
    public int compare(Service service1, Service service2) {

        Integer service1Cost = service1.getCost();
        Integer service2Cost = service2.getCost();
        return service1Cost.compareTo(service2Cost);
    }
}