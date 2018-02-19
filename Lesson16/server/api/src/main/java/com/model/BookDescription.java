package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "book_description")
public class BookDescription extends WebEntity {

    private String book_description;

    public BookDescription() {
    }

    public BookDescription(String book_description) {
        this.book_description = book_description;
    }

    public BookDescription(Long id, String book_description) {
        super(id);
        this.book_description = book_description;
    }

    @Column(name = "description")
    public String getBook_description() {
        return book_description;
    }

    public void setBook_description(String book_description) {
        this.book_description = book_description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookDescription that = (BookDescription) o;

        return book_description != null ? book_description.equals(that.book_description) : that.book_description == null;
    }

    @Override
    public int hashCode() {
        return book_description != null ? book_description.hashCode() : 0;
    }
}
