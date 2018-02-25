package com.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shop_contact")
public class ShopContact extends  WebEntity {
    private List<ShopPhone> phoneList;
    private Address address;
    private ShopFilialStatus shopFilialStatus;
    private ShopData shopData;

    public ShopContact(){}

    public ShopContact(
                       Address address,
                       ShopFilialStatus shopFilialStatus,
                       ShopData shopData) {
        this.phoneList = new ArrayList<ShopPhone>();
        this.address = address;
        this.shopFilialStatus = shopFilialStatus;
        this.shopData = shopData;
    }

    public ShopContact(Integer id,
                       Address address,
                       ShopFilialStatus shopFilialStatus,
                       ShopData shopData) {
        super(id);
        this.phoneList = new ArrayList<ShopPhone>();
        this.address = address;
        this.shopFilialStatus = shopFilialStatus;
        this.shopData = shopData;
    }

    @JoinColumn(name = "address")
    @OneToOne
    public Address getAddress() {
        return address;
    }

    @OneToMany(mappedBy="shopContact")
    public List<ShopPhone> getPhoneList() {
        return phoneList;
    }


    @ManyToOne
    @JoinColumn(name = "shop_data")
    public ShopData getShopData() {
        return shopData;
    }

    @Enumerated
    @Column(name = "filial_status", columnDefinition = "smallint")
    public ShopFilialStatus getShopFilialStatus() {
        return shopFilialStatus;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setPhoneList(List<ShopPhone> phoneList) {
        this.phoneList = phoneList;
    }

    public void setShopFilialStatus(ShopFilialStatus shopFilialStatus) {
        this.shopFilialStatus = shopFilialStatus;
    }

    public void setShopData(ShopData shopData) {
        this.shopData = shopData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShopContact that = (ShopContact) o;

        if (phoneList != null ? !phoneList.equals(that.phoneList) : that.phoneList != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        return shopFilialStatus == that.shopFilialStatus;
    }

    @Override
    public int hashCode() {
        int result = phoneList != null ? phoneList.hashCode() : 0;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (shopFilialStatus != null ? shopFilialStatus.hashCode() : 0);
        return result;
    }
}
