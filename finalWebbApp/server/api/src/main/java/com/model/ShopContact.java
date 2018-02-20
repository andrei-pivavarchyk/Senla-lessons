package com.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shop_contact")
public class ShopContact extends  WebEntity {
    private List<ShopPhone> phoneList;
    private Address address;
    private ShopFilialStatus shopFilialStatus;

    public ShopContact(){}

    public ShopContact(List<ShopPhone> phoneList, Address address, ShopFilialStatus shopFilialStatus) {
        this.phoneList = phoneList;
        this.address = address;
        this.shopFilialStatus = shopFilialStatus;
    }

    public ShopContact(Long id, List<ShopPhone> phoneList, Address address, ShopFilialStatus shopFilialStatus) {
        super(id);
        this.phoneList = phoneList;
        this.address = address;
        this.shopFilialStatus = shopFilialStatus;
    }

    @JoinColumn(name = "address")
    @OneToOne
    public Address getAddress() {
        return address;
    }

    @Column(name = "phone_list")
    @OneToMany
    public List<ShopPhone> getPhoneList() {
        return phoneList;
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
