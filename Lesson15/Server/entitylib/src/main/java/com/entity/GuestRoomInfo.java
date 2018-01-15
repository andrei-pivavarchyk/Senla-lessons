package com.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "guestroominfo")
public class GuestRoomInfo extends HotelEntity {
    @JsonManagedReference
    public Guest guest;
    @JsonManagedReference
    public Room room;
    private Date arrivaldate;
    private Date departuredate;
    private Boolean isStillLiving = true;

    public GuestRoomInfo(Guest guest, Room room, Date arrivaldate, Date departuredate, Boolean isStillLiving) {
        this.guest = guest;
        this.room = room;
        this.departuredate = departuredate;
        this.arrivaldate = arrivaldate;
        this.isStillLiving = isStillLiving;
    }

    public GuestRoomInfo(Integer id, Guest guest, Room room, Date arrivaldate, Date departuredate, Boolean isStillLiving) {
        super(id);
        this.guest = guest;
        this.room = room;
        this.departuredate = departuredate;
        this.arrivaldate = arrivaldate;
        this.isStillLiving = isStillLiving;
    }

    public GuestRoomInfo() {
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

    @Column(name = "isStillLiving", nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    public Boolean getIsstillliving() {
        return isStillLiving;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "guest")
    public Guest getGuest() {
        return guest;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room")

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public void setIsstillliving(Boolean isstillliving) {
        this.isStillLiving = isstillliving;
    }

    public void setDeparturedate(Timestamp departuredate) {
        this.departuredate = departuredate;
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
        int result = (int) getId();
        result = 31 * result + (arrivaldate != null ? arrivaldate.hashCode() : 0);
        result = 31 * result + (departuredate != null ? departuredate.hashCode() : 0);
        result = 31 * result + (isStillLiving != null ? isStillLiving.hashCode() : 0);
        return result;
    }
}
