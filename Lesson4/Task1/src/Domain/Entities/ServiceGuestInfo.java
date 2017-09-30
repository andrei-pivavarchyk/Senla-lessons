package Domain.Entities;

import java.util.Date;

public class ServiceGuestInfo {
    public ServiceGuestInfo(Guest guest, Service service, Date dateOfOrder, boolean isPaid) {
        this.guest = guest;
        this.service = service;
        this.dateOfOrder = dateOfOrder;
        this.isPaid = isPaid;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public void setDateOfOrder(Date dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public Guest getGuest() {
        return guest;
    }

    public Service getService() {
        return service;
    }

    public Date getDateOfOrder() {
        return dateOfOrder;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setWasPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    private Guest guest;
    private Service service;
    private Date dateOfOrder;
    private boolean isPaid;

    public String toString() {
        return String.format("Guest: %s. Service: %s. Date: %s", guest.getSurName(), service, dateOfOrder);
    }
}
