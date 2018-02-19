package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "shop_data")
public class ShopData extends WebEntity{

    private String name;
    private ShopContact contact;

    public ShopData(){}

    public ShopData(String name, ShopContact contact) {
        this.name = name;
        this.contact = contact;
    }

    public ShopData(Long id, String name, ShopContact contact) {
        super(id);
        this.name = name;
        this.contact = contact;
    }
    @Column(name = "name")
    public String getName() {
        return name;
    }
    @Column(name = "contact")
    public ShopContact getContact() {
        return contact;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContact(ShopContact contact) {
        this.contact = contact;
    }
}
