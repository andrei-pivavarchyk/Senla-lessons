package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address extends WebEntity{

    private String street;
    private String city;
    private String region;
    private String country;
    private Integer index;


    public Address(){}


    public Address(String street, String city, String region, String country, Integer index) {
        this.street = street;
        this.city = city;
        this.region = region;
        this.country = country;
        this.index = index;
    }

    public Address(Integer id, String street, String city, String region, String country, Integer index) {
        super(id);
        this.street = street;
        this.city = city;
        this.region = region;
        this.country = country;
        this.index = index;
    }

    @Column(name = "street")
    public String getStreet() {
        return street;
    }
    @Column(name = "city")
    public String getCity() {
        return city;
    }
    @Column(name = "region")
    public String getRegion() {
        return region;
    }
    @Column(name = "country")
    public String getCountry() {
        return country;
    }
    @Column(name = "post_index")
    public Integer getIndex() {
        return index;
    }


    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (street != null ? !street.equals(address.street) : address.street != null) return false;
        if (city != null ? !city.equals(address.city) : address.city != null) return false;
        if (region != null ? !region.equals(address.region) : address.region != null) return false;
        if (country != null ? !country.equals(address.country) : address.country != null) return false;
        return index != null ? index.equals(address.index) : address.index == null;
    }

    @Override
    public int hashCode() {
        int result = street != null ? street.hashCode() : 0;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (index != null ? index.hashCode() : 0);
        return result;
    }
}
