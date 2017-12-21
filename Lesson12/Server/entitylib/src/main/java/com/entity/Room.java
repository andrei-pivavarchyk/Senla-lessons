package com.entity;

import com.entityOld.Guest;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * Created by андрей on 21.12.2017.
 */
@Entity
@Table(name = "room")
public class Room extends HotelEntity{
    private Integer number;
    private Integer cost;
    private Integer capacity;
    private Integer stars;
    private RoomStatus status;

    @JsonCreator
    public Room(@JsonProperty("id") Integer id, @JsonProperty("number") Integer number, @JsonProperty("cost") Integer cost, @JsonProperty("capacity") Integer capacity, @JsonProperty("stars") Integer stars) {
        super(id);
        this.number = number;
        this.cost = cost;
        this.capacity = capacity;
        this.stars = stars;

    }
    @Basic
    @Column(name = "number")
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Basic
    @Column(name = "cost")
    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Basic
    @Column(name = "capacity")
    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Basic
    @Column(name = "stars")
    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    @Basic
    @Column(name = "status")
    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room that = (Room) o;

        if (getId() != that.getId()) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (cost != null ? !cost.equals(that.cost) : that.cost != null) return false;
        if (capacity != null ? !capacity.equals(that.capacity) : that.capacity != null) return false;
        if (stars != null ? !stars.equals(that.stars) : that.stars != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        result = 31 * result + (capacity != null ? capacity.hashCode() : 0);
        result = 31 * result + (stars != null ? stars.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
