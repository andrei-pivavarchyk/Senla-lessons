package com.serviceAPI;

import com.model.*;

import java.util.List;

public interface IOrderService {
    List<Order> getAllOrders();
    void createOrder(UserData userData,List<Book> bookList);
    Integer getOrderCost(List<Book> bookList);
    void setOrderStatus(Integer orderID, OrderStatus status);
    List<Order> getAllUserOrders(User user);
}