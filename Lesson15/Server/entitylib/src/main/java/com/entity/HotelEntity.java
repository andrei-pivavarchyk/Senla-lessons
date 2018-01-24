package com.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import java.io.Serializable;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Room.class, name = "room"),
        @JsonSubTypes.Type(value = Guest.class, name = "guest"),
        @JsonSubTypes.Type(value = Service.class, name = "service"),
        @JsonSubTypes.Type(value = GuestServiceInfo.class, name = "gsinfo"),
        @JsonSubTypes.Type(value = GuestRoomInfo.class, name = "grinfo")
})

@MappedSuperclass
public class HotelEntity implements Serializable {
    private Integer id;


    protected HotelEntity() {
    }

    @JsonCreator
    public HotelEntity(@JsonProperty("id") Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
