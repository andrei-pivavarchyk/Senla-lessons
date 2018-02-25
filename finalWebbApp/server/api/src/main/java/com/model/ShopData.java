package com.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shop_data")
public class ShopData extends WebEntity{

    private String name;
    private List<ShopContact> listOfContacts;

    public ShopData(){}

    public ShopData(String name) {
        this.name = name;
        this.listOfContacts = new ArrayList<ShopContact>();
    }

    public ShopData(Integer id, String name) {
        super(id);
        this.name = name;
        this.listOfContacts = new ArrayList<ShopContact>();
    }

    @OneToMany(mappedBy="shopData")
    public List<ShopContact> getListOfContacts() {
        return listOfContacts;
    }

    @Column(name = "shop_name")
    public String getName() {
        return name;
    }

    public void setListOfContacts(List<ShopContact> listOfContacts) {
        this.listOfContacts = listOfContacts;
    }


    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShopData shopData = (ShopData) o;

        if (name != null ? !name.equals(shopData.name) : shopData.name != null) return false;
        return listOfContacts != null ? listOfContacts.equals(shopData.listOfContacts) : shopData.listOfContacts == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (listOfContacts != null ? listOfContacts.hashCode() : 0);
        return result;
    }
}
