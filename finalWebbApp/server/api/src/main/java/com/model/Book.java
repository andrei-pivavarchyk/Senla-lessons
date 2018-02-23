package com.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book extends WebEntity {
    private String bookName;
    private Integer bookCost;
    private BookGenre genre;
    private Author author;
    private BookStatus bookStatus;
    private String bookDescription;
    private Set<Feedback> feedbackList;

    public Book() {
    }

    public Book(String bookName,
                Integer bookCost,
                BookGenre genre,
                Author author,
                BookStatus bookStatus,
                String bookDescription) {
        this.bookName = bookName;
        this.bookCost = bookCost;
        this.genre = genre;
        this.author = author;
        this.bookStatus = bookStatus;
        this.bookDescription = bookDescription;
        this.feedbackList=new HashSet<Feedback>();
    }

    public Book(Integer id,
                String bookName,
                Integer bookCost,
                BookGenre genre,
                Author author,
                BookStatus bookStatus,
                String bookDescription) {
        super(id);
        this.bookName = bookName;
        this.bookCost = bookCost;
        this.genre = genre;
        this.author = author;
        this.bookStatus = bookStatus;
        this.bookDescription = bookDescription;
        this.feedbackList=new HashSet<Feedback>();
    }

    @Column(name = "book_name")
    public String getBookName() {
        return bookName;
    }

    @Enumerated
    @Column(name = "genre", columnDefinition = "smallint")
    public BookGenre getGenre() {
        return genre;
    }

    @JoinColumn(name = "author")
    @OneToOne
    public Author getAuthor() {
        return author;
    }

    @Column(name = "book_cost")
    public Integer getBookCost() {
        return bookCost;
    }

    @Column(name = "book_description")
    public String getBookDescription() {
        return bookDescription;
    }

    @Enumerated
    @Column(name = "book_status", columnDefinition = "smallint")
    public BookStatus getBookStatus() {
        return bookStatus;
    }

    @OneToMany
    public Set<Feedback> getFeedbackList() {
        return feedbackList;
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

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public void setFeedbackList(Set<Feedback> feedbackList) {
        this.feedbackList = feedbackList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        if (bookName != null ? !bookName.equals(book.bookName) : book.bookName != null) return false;
        if (bookCost != null ? !bookCost.equals(book.bookCost) : book.bookCost != null) return false;
        if (genre != null ? !genre.equals(book.genre) : book.genre != null) return false;
        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        if (bookStatus != book.bookStatus) return false;
        return bookDescription != null ? bookDescription.equals(book.bookDescription) : book.bookDescription == null;
    }

    @Override
    public int hashCode() {
        int result = bookName != null ? bookName.hashCode() : 0;
        result = 31 * result + (bookCost != null ? bookCost.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (bookStatus != null ? bookStatus.hashCode() : 0);
        result = 31 * result + (bookDescription != null ? bookDescription.hashCode() : 0);
        return result;
    }
}
