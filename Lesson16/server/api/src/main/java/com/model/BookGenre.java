package com.model;

import javax.persistence.*;

@Entity
@Table(name = "genre")
public class BookGenre extends WebEntity{

private String genre;

public BookGenre(){}

    public BookGenre(String genre) {
        this.genre = genre;
    }

    public BookGenre(Long id, String genre) {
        super(id);
        this.genre = genre;
    }
    @Column(name = "genre")
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
