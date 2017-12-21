package com.entity;

import javax.persistence.*;

@MappedSuperclass
public class HotelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

public HotelEntity(Integer id){
    this.id=id;
}
public  HotelEntity(){}

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

}
