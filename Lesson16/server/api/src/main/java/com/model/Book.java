package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book extends WebEntity {
    private String bookName;
    private Integer bookCost;
    private BookGenre genre;
    private Author author;
    private BookStatus bookStatus;
    private BookDescription bookDescription;

    public Book() {
    }

    public Book(String bookName,
                Integer bookCost,
                BookGenre genre,
                Author author,
                BookStatus bookStatus,
                BookDescription bookDescription) {
        this.bookName = bookName;
        this.bookCost = bookCost;
        this.genre = genre;
        this.author = author;
        this.bookStatus = bookStatus;
        this.bookDescription = bookDescription;
    }

    public Book(Long id,
                String bookName,
                Integer bookCost,
                BookGenre genre,
                Author author,
                BookStatus bookStatus,
                BookDescription bookDescription) {
        super(id);
        this.bookName = bookName;
        this.bookCost = bookCost;
        this.genre = genre;
        this.author = author;
        this.bookStatus = bookStatus;
        this.bookDescription = bookDescription;
    }

    @Column(name = "book_name")
    public String getBookName() {
        return bookName;
    }


   // @Enumerated
    @Column(name = "book_genre",columnDefinition = "smallint")
    public BookGenre getGenre() {
        return genre;
    }

    @Column(name = "author")
    public Author getAuthor() {
        return author;
    }

    @Column(name = "book_cost")
    public Integer getBookCost() {
        return bookCost;
    }

    @Column(name = "book_description")
    public BookDescription getBookDescription() {
        return bookDescription;
    }

    @Enumerated
    @Column(name = "book_status",columnDefinition = "smallint")
    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookCost(Integer bookCost) {
        this.bookCost = bookCost;
    }

    public void setGenre(BookGenre genre) {
        this.genre = genre;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }

    public void setBookDescription(BookDescription bookDescription) {
        this.bookDescription = bookDescription;
    }
}
