package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "order")
public class Order extends WebEntity {

    public Order() {
    }

    private User user;
    private Book book;
    private Integer bookCost;
    private OrderStatus orderStatus;
    private Date creationDate;


    public Order(User user,
                 Book book,
                 Integer bookCost,
                 OrderStatus orderStatus,
                 Date creationDate) {
        this.user = user;
        this.book = book;
        this.bookCost = bookCost;
        this.orderStatus = orderStatus;
        this.creationDate = creationDate;
    }

    public Order(Long id,
                 User user,
                 Book book,
                 Integer bookCost,
                 OrderStatus orderStatus,
                 Date creationDate) {
        super(id);
        this.user = user;
        this.book = book;
        this.bookCost = bookCost;
        this.orderStatus = orderStatus;
        this.creationDate = creationDate;
    }

    @Column(name = "user_id")
    public User getUser() {
        return user;
    }

    @Column(name = "book_id")
    public Book getBook() {
        return book;
    }

    @Column(name = "creation_date")
    public Date getCreationDate() {
        return creationDate;
    }

    @Column(name = "book_cost")
    public Integer getBookCost() {
        return bookCost;
    }

    @Enumerated
    @Column(name = "order_status",columnDefinition = "smallint")
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setBookCost(Integer bookCost) {
        this.bookCost = bookCost;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
