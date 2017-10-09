package comparator;

import entity.Service;

import java.util.Comparator;

public class ServiceCostComparator implements Comparator<Service> {
    public int compare(Service service1, Service service2) {
        try {
            Integer service1Cost = service1.getCost();
            Integer service2Cost = service2.getCost();
            return service1Cost.compareTo(service2Cost);
        } catch (Exception e) {
            System.out.print(e);
        }
        return 0;
    }
}
