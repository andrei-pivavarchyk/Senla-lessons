package com.dao;

import com.daoAPI.IOrderDAO;
import com.model.Order;

public class OrderDAO extends BaseDAO<Order> implements IOrderDAO {
    public OrderDAO() {
        super(Order.class);
    }
}
