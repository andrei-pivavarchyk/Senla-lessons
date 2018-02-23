package com.model;

public enum BookGenre {
    FANTASTIC,
    NOVEL,
    DETECTIVE,
}
















/*
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookGenre bookGenre = (BookGenre) o;

        return genre != null ? genre.equals(bookGenre.genre) : bookGenre.genre == null;
    }

    @Override
    public int hashCode() {
        return genre != null ? genre.hashCode() : 0;
    }
}
*/