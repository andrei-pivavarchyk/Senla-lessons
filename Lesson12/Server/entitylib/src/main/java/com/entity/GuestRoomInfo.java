package com.entity;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;



@Entity
@Table(name = "guestroominfo")
public class GuestRoomInfo extends HotelEntity{

    private Guest guest;
    private Room room;
    private Date arrivaldate;
    private Date departuredate;
    private Byte isStillLiving;

    public GuestRoomInfo(int id,Guest guest,Room room,Date arrivaldate,Date departuredate,Byte isStillLiving) {
        super(id);
        this.guest=guest;
        this.room=room;
        this.departuredate=departuredate;
        this.arrivaldate=arrivaldate;
    }


    @Basic
    @Column(name = "arrivaldate")
    public Date getArrivaldate() {
        return arrivaldate;
    }

    public void setArrivaldate(Timestamp arrivaldate) {
        this.arrivaldate = arrivaldate;
    }

    @Basic
    @Column(name = "departuredate")
    public Date getDeparturedate() {
        return departuredate;
    }

    public void setDeparturedate(Timestamp departuredate) {
        this.departuredate = departuredate;
    }

    @Basic
    @Column(name = "isstillliving")
    public Byte getIsstillliving() {
        return isStillLiving;
    }

    public void setIsstillliving(Byte isstillliving) {
        this.isStillLiving = isstillliving;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }
    @ManyToOne(cascade = CascadeType.ALL)
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GuestRoomInfo that = (GuestRoomInfo) o;

        if (getId() != that.getId()) return false;
        if (arrivaldate != null ? !arrivaldate.equals(that.arrivaldate) : that.arrivaldate != null) return false;
        if (departuredate != null ? !departuredate.equals(that.departuredate) : that.departuredate != null)
            return false;
        if (isStillLiving != null ? !isStillLiving.equals(that.isStillLiving) : that.isStillLiving != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (arrivaldate != null ? arrivaldate.hashCode() : 0);
        result = 31 * result + (departuredate != null ? departuredate.hashCode() : 0);
        result = 31 * result + (isStillLiving != null ? isStillLiving.hashCode() : 0);
        return result;
    }
}
