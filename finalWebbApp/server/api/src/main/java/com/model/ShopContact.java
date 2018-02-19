package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "shop_contact")
public class ShopContact extends  WebEntity{
    private Integer phone;
    private ShopAddress address;

    public ShopContact(Integer phone, ShopAddress address) {
        this.phone = phone;
        this.address = address;
    }

    public ShopContact(Long id, Integer phone, ShopAddress address) {
        super(id);
        this.phone = phone;
        this.address = address;
    }
    @Column(name = "phone")
    public Integer getPhone() {
        return phone;
    }
    @Column(name = "address")
    public ShopAddress getAddress() {
        return address;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public void setAddress(ShopAddress address) {
        this.address = address;
    }

}
