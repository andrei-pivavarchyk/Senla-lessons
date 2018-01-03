package com.entity;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class HotelEntity implements Serializable {
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
