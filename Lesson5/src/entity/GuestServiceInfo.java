package entity;


import java.util.Date;

public class GuestServiceInfo extends Entity {

    private Guest guest;
    private Service service;
    private Date date;


    public GuestServiceInfo(int id, Guest guest, Service service, Date date) {
        super(id);
        this.guest = guest;
        this.service = service;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public Guest getGuest() {
        return guest;
    }

    public Service getService() {
        return service;
    }

}
