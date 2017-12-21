package com.entity;

import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


@Entity
@Table(name = "guestserviceinfo")
public class GuestServiceInfo extends HotelEntity{

    private Guest guest;
    private Service service;
    private Date date;

    public GuestServiceInfo(Integer id, Guest guest, Service service, Date date) {
        super(id);
        this.guest=guest;
        this.service=service;
        this.date=date;
    }
public GuestServiceInfo(){}

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Guest getGuest() {
        return guest;
    }
    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GuestServiceInfo that = (GuestServiceInfo) o;

        if (getId() != that.getId()) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result =(int) getId();
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
