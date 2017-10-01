package Domain.Entities;

import java.util.Date;

public class GuestServiceInfo extends Entity {
    private Guest guest;
    private Service service;
    private Date dateOfOrder;
    private boolean isPaid;

    public GuestServiceInfo(Guest guest, Service service, Date dateOfOrder, boolean isPaid) {
        super(1);
        this.guest = guest;
        this.service = service;
        this.dateOfOrder = dateOfOrder;
        this.isPaid = isPaid;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Date getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(Date dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setWasPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public String toString() {
        return String.format("Guest: %s. Service: %s. Date: %s", guest.getSurName(), service.getTitle(), dateOfOrder);
    }
}