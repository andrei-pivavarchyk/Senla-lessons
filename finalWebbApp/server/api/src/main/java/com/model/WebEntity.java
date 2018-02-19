package com.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import java.io.Serializable;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@MappedSuperclass
public abstract class WebEntity implements Serializable {

    private Long id;

    public WebEntity() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public WebEntity(Long id) {
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
