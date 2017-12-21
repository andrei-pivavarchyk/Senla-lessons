package com.entity;

import javax.persistence.*;

@MappedSuperclass
public class HotelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

public HotelEntity(int id){
    this.id=id;
}

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

}
