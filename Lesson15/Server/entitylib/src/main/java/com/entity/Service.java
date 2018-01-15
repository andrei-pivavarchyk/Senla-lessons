package com.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "service")
public class Service extends HotelEntity {
    private String name;
    private Integer cost;
    private ServiceType type;
    private List<GuestServiceInfo> guestServiceInfoList;

    public Service(Integer id, ServiceType type, String name, int cost) {
        super(id);
        this.name = name;
        this.cost = cost;
        this.type = type;
    }

    public Service() {
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Basic
    @Column(name = "cost")
    public Integer getCost() {
        return cost;
    }

    @Basic
    @Column(name = "type")
    @Enumerated(EnumType.ORDINAL)
    public ServiceType getType() {
        return type;
    }

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    public List<GuestServiceInfo> getGuestServiceInfoList() {
        return guestServiceInfoList;
    }

    public void setGuestServiceInfoList(List<GuestServiceInfo> guestServiceInfoList) {
        this.guestServiceInfoList = guestServiceInfoList;
    }

    public void setType(ServiceType type) {
        this.type = type;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service that = (Service) o;
        if (getId() != that.getId()) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (cost != null ? !cost.equals(that.cost) : that.cost != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) getId();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        String str = this.getId() + this.name;
        return str;
    }
}
