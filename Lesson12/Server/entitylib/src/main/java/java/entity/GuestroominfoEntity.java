package entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by андрей on 21.12.2017.
 */
@Entity
@Table(name = "guestroominfo", schema = "hotel5", catalog = "")
public class GuestroominfoEntity {
    private int id;
    private Timestamp arrivaldate;
    private Timestamp departuredate;
    private Byte isstillliving;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "arrivaldate")
    public Timestamp getArrivaldate() {
        return arrivaldate;
    }

    public void setArrivaldate(Timestamp arrivaldate) {
        this.arrivaldate = arrivaldate;
    }

    @Basic
    @Column(name = "departuredate")
    public Timestamp getDeparturedate() {
        return departuredate;
    }

    public void setDeparturedate(Timestamp departuredate) {
        this.departuredate = departuredate;
    }

    @Basic
    @Column(name = "isstillliving")
    public Byte getIsstillliving() {
        return isstillliving;
    }

    public void setIsstillliving(Byte isstillliving) {
        this.isstillliving = isstillliving;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GuestroominfoEntity that = (GuestroominfoEntity) o;

        if (id != that.id) return false;
        if (arrivaldate != null ? !arrivaldate.equals(that.arrivaldate) : that.arrivaldate != null) return false;
        if (departuredate != null ? !departuredate.equals(that.departuredate) : that.departuredate != null)
            return false;
        if (isstillliving != null ? !isstillliving.equals(that.isstillliving) : that.isstillliving != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (arrivaldate != null ? arrivaldate.hashCode() : 0);
        result = 31 * result + (departuredate != null ? departuredate.hashCode() : 0);
        result = 31 * result + (isstillliving != null ? isstillliving.hashCode() : 0);
        return result;
    }
}
