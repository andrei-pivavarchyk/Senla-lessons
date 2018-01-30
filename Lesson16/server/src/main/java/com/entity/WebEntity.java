package com.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by андрей on 29.01.2018.
 */

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")/*
@JsonSubTypes({
        @JsonSubTypes.Type(value = Room.class, name = "room"),
})
*/
@MappedSuperclass
public class WebEntity implements Serializable {
    private Integer id;


    protected WebEntity() {
    }

    @JsonCreator
    public WebEntity(@JsonProperty("id") Integer id) {
        this.id = id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }
}
