package com.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "feedback")
public class Feedback extends WebEntity{

    private UserData userData;
    private Book book;
    private String title;
    private String feedback;


    public Feedback(){}


    public Feedback(UserData user, Book book, String title, String feedback) {
        this.userData = userData;
        this.book = book;
        this.title = title;
        this.feedback = feedback;
    }

    public Feedback(Integer id, UserData userData, Book book, String title, String feedback) {
        super(id);
        this.userData = userData;
        this.book = book;
        this.title = title;
        this.feedback = feedback;
    }



    @ManyToOne
    @JoinColumn(name = "book")
    public Book getBook() {
        return book;
    }

    @ManyToOne
    @JoinColumn(name = "user_data")
    public UserData getUserData() {
        return userData;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }
    @Column(name = "feedback")
    public String getFeedback() {
        return feedback;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}