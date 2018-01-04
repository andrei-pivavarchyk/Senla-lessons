package com.serverQueryService.ClientQueryService;


import com.entity.RoomStatus;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;



@Entity
@Table(name = "room")

public class RRoom extends HHotelEntity  {
    private Integer id;
    private Integer cost;
    private Integer number;
    private Integer capacity;
    private Integer stars;
    @Enumerated(EnumType.ORDINAL)
    private RoomStatus status;




    @JsonCreator
    public RRoom(@JsonProperty("id") Integer id,  @JsonProperty("cost") Integer cost, @JsonProperty("number") Integer number,@JsonProperty("capacity") Integer capacity, @JsonProperty("stars") Integer stars) {
       super();
        this.id=id;
        this.cost = cost;
        this.number = number;
        this.capacity = capacity;
        this.stars = stars;
        this.status=RoomStatus.FREE;
    }

    public RRoom(){}
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


    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }
@JsonGetter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com.entity.Room that = (com.entity.Room) o;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (cost != null ? !cost.equals(that.cost) : that.cost != null) return false;
        if (capacity != null ? !capacity.equals(that.capacity) : that.capacity != null) return false;
        if (stars != null ? !stars.equals(that.stars) : that.stars != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        return true;
    }*/

    @Override
    public int hashCode() {
       /* int result = (int)getId();
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        result = 31 * result + (capacity != null ? capacity.hashCode() : 0);
        result = 31 * result + (stars != null ? stars.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;*/
       return 1;
    }
}
