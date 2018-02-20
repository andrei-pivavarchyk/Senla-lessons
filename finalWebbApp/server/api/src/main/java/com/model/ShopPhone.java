package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "shop_phone")
public class ShopPhone extends WebEntity {
    private Integer phone;
    private ShopPhoneType shopPhoneType;

    public ShopPhone(Integer phone, ShopPhoneType shopPhoneType) {
        this.phone = phone;
        this.shopPhoneType = shopPhoneType;
    }

    public ShopPhone(Long id, Integer phone, ShopPhoneType shopPhoneType) {
        super(id);
        this.phone = phone;
        this.shopPhoneType = shopPhoneType;
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