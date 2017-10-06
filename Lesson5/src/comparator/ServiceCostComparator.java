package comparator;

import entity.Room;
import entity.Service;

import java.util.Comparator;

/**
 * Created by андрей on 06.10.2017.
 */
public class ServiceCostComparator implements Comparator<Service> {
    public int compare(Service service1, Service service2) {
        Integer service1Cost = service1.getCost();
        Integer service2Cost = service2.getCost();
        return service1Cost.compareTo(service2Cost);

    }
}
