package com.entity;

import javax.persistence.*;

@MappedSuperclass
public class HotelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

public  HotelEntity(){}
    public  HotelEntity(Integer id){
    this.id=id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }



}
