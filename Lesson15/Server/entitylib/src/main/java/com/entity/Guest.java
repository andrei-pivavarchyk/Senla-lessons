package com.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.List;



@Entity
@Table(name = "guest")
public class Guest extends HotelEntity {
    private String name;
    private String surname;
    private List<GuestRoomInfo> guestRoomInfoList;
    private List<GuestServiceInfo> guestServiceInfoList;

    public Guest(String name, String surName) {
        this.name = name;
        this.surname = surName;
    }

    @JsonCreator
    public Guest(@JsonProperty("id") Integer id, @JsonProperty("name") String name, @JsonProperty("surName") String surName) {
        super(id);
        this.name = name;
        this.surname = surName;
    }

    public Guest() {
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    @OneToMany
    @JsonBackReference
    public List<GuestRoomInfo> getGuestRoomInfoList() {
        return guestRoomInfoList;
    }

    @OneToMany
    @JsonBackReference
    public List<GuestServiceInfo> getGuestServiceInfoList() {
        return guestServiceInfoList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setGuestRoomInfoList(List<GuestRoomInfo> guestRoomInfoList) {
        this.guestRoomInfoList = guestRoomInfoList;
    }

    public void setGuestServiceInfoList(List<GuestServiceInfo> guestServiceInfoList) {
        this.guestServiceInfoList = guestServiceInfoList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guest that = (Guest) o;
        if (getId() != that.getId()) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) getId();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        return result;
    }
}
