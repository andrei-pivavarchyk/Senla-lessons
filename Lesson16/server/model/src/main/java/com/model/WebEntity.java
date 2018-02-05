package com.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import java.io.Serializable;

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
