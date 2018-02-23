package com.dao;

import com.daoAPI.IOrderDAO;
import com.model.Order;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDAO extends BaseDAO<Order> implements IOrderDAO {
    public OrderDAO() {
        super(Order.class);
    }
}
