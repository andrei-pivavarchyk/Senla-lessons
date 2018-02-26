package com.daoAPI;

import com.model.Order;
import com.model.UserData;

import java.util.List;

public interface IOrderDAO extends IBaseDAO<Order> {
    List<Order> getAllOrders() throws Exception;
    List<Order> getAllOrdersByUser(UserData userData) throws Exception;
}
