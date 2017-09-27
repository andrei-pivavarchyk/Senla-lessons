package comparator;

import guestService.Service;

import java.util.Comparator;
import java.util.Date;


public class ServiceDateComparator implements Comparator<Service> {
    @Override
    public int compare(Service service1, Service service2) {
       Date service1Date=service1.getDate();
        Date service2Date=service2.getDate();
        return service1Date.compareTo(service2Date);

    }
}