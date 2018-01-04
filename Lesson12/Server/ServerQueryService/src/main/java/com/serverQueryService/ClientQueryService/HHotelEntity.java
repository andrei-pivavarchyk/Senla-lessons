package com.serverQueryService.ClientQueryService;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

//@MappedSuperclass

public  class HHotelEntity implements Serializable {

    protected HHotelEntity() {
    }
  //  @Id
  //  @GeneratedValue(strategy = GenerationType.AUTO)
  //  @Column(name = "id")
  //  private Integer id;

 /*
 @JsonCreator
    public HHotelEntity() {
    }


    @JsonCreator
    public HHotelEntity(@JsonProperty("id") Integer id) {
        this.id = id;
    }

   public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

*/
}