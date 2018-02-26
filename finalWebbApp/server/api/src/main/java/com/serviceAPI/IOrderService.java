package com.serviceAPI;

import com.model.Book;
import com.model.Order;
import com.model.OrderStatus;
import com.model.UserData;

import java.util.List;

public interface IOrderService {
    List<Order> getAllOrders();
    List<Order> getAllOrdersByUser(UserData userData);
    void createOrder(UserData userData,List<Book> bookList);
    Integer getOrderCost(List<Book> bookList);
    void setOrderStatus(Integer orderID, OrderStatus status);
}