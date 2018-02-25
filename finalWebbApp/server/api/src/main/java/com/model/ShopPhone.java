package com.model;

import javax.persistence.*;

@Entity
@Table(name = "shop_phone")
public class ShopPhone extends WebEntity {
    private Integer phone;
    private ShopPhoneType shopPhoneType;
    private ShopContact shopContact;

    public ShopPhone(Integer phone, ShopPhoneType shopPhoneType, ShopContact shopContact) {
        this.phone = phone;
        this.shopPhoneType = shopPhoneType;
        this.shopContact = shopContact;
    }

    public ShopPhone(Integer id, Integer phone, ShopPhoneType shopPhoneType, ShopContact shopContact) {
        super(id);
        this.phone = phone;
        this.shopPhoneType = shopPhoneType;
        this.shopContact = shopContact;
    }

    @ManyToOne
    @JoinColumn(name = "shop_contact")
    public ShopContact getShopContact() {
        return shopContact;
    }


    @Column(name = "phone")
    public Integer getPhone() {
        return phone;
    }

    @Enumerated
    @Column(name = "phone_type", columnDefinition = "smallint")
    public ShopPhoneType getShopPhoneType() {
        return shopPhoneType;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public void setShopPhoneType(ShopPhoneType shopPhoneType) {
        this.shopPhoneType = shopPhoneType;
    }

    public void setShopContact(ShopContact shopContact) {
        this.shopContact = shopContact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShopPhone shopPhone = (ShopPhone) o;

        if (phone != null ? !phone.equals(shopPhone.phone) : shopPhone.phone != null) return false;
        return shopPhoneType == shopPhone.shopPhoneType;
    }

    @Override
    public int hashCode() {
        int result = phone != null ? phone.hashCode() : 0;
        result = 31 * result + (shopPhoneType != null ? shopPhoneType.hashCode() : 0);
        return result;
    }
}