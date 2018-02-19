package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "shop_address")
public class ShopAddress extends WebEntity{

    private String street;
    private String city;
    private String region;
    private String country;

    public ShopAddress(){
    }

    public ShopAddress(String street, String city, String region, String country) {
        this.street = street;
        this.city = city;
        this.region = region;
        this.country = country;
    }

    public ShopAddress(Long id, String street, String city, String region, String country) {
        super(id);
        this.street = street;
        this.city = city;
        this.region = region;
        this.country = country;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShopAddress that = (ShopAddress) o;

        if (street != null ? !street.equals(that.street) : that.street != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (region != null ? !region.equals(that.region) : that.region != null) return false;
        return country != null ? country.equals(that.country) : that.country == null;
    }

    @Override
    public int hashCode() {
        int result = street != null ? street.hashCode() : 0;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }
}
