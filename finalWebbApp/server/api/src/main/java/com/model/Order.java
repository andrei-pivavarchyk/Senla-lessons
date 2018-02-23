package com.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user_order")
public class Order extends WebEntity {

    public Order() {
    }

    private Integer orderCost;
    private OrderStatus orderStatus;
    private Date creationDate;
    private UserData userData;
    private Set<Book> listOrderBooks;

    public Order(Integer orderCost,
                 OrderStatus orderStatus,
                 Date creationDate,
                 UserData userData,
                 Set<Book> listOrderBooks) {
        this.orderCost = orderCost;
        this.orderStatus = orderStatus;
        this.creationDate = creationDate;
        this.userData = userData;
        this.listOrderBooks = listOrderBooks;
    }

    public Order(Integer id,
                 Integer orderCost,
                 OrderStatus orderStatus,
                 Date creationDate,
                 UserData userData,
                 Set<Book> listOrderBooks) {
        super(id);
        this.orderCost = orderCost;
        this.orderStatus = orderStatus;
        this.creationDate = creationDate;
        this.userData = userData;
        this.listOrderBooks = listOrderBooks;
    }

    @Column(name = "creation_date")
    public Date getCreationDate() {
        return creationDate;
    }

    @Column(name = "order_cost")
    public Integer getOrderCost() {
        return orderCost;
    }

    @Enumerated
    @Column(name = "order_status",columnDefinition = "smallint")
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    @JoinColumn(name = "user_data")
    @OneToOne
    public UserData getUserData() {
        return userData;
    }

    @OneToMany
    public Set<Book> getListOrderBooks() {
        return listOrderBooks;
    }


    public void setOrderCost(Integer orderCost) {
        this.orderCost = orderCost;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public void setListOrderBooks(Set<Book> listOrderBooks) {
        this.listOrderBooks = listOrderBooks;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (orderCost != null ? !orderCost.equals(order.orderCost) : order.orderCost != null) return false;
        if (orderStatus != order.orderStatus) return false;
        if (creationDate != null ? !creationDate.equals(order.creationDate) : order.creationDate != null) return false;
        if (userData != null ? !userData.equals(order.userData) : order.userData != null) return false;
        return listOrderBooks != null ? listOrderBooks.equals(order.listOrderBooks) : order.listOrderBooks == null;
    }

    @Override
    public int hashCode() {
        int result = orderCost != null ? orderCost.hashCode() : 0;
        result = 31 * result + (orderStatus != null ? orderStatus.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (userData != null ? userData.hashCode() : 0);
        result = 31 * result + (listOrderBooks != null ? listOrderBooks.hashCode() : 0);
        return result;
    }
}
