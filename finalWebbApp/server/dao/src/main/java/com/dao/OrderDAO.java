package com.dao;

import com.daoAPI.IOrderDAO;
import com.model.Book;
import com.model.Order;
import com.model.UserData;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDAO extends BaseDAO<Order> implements IOrderDAO {
    public OrderDAO() {
        super(Order.class);
    }


    public List<Order> getAllOrders(){
        Criteria criteria = getSession().createCriteria(Order.class);

        List<Order> orderList = criteria.list();
        return orderList;
    }

    public List<Order> getAllOrdersByUser(UserData userData){

        Criteria criteria = getSession().createCriteria(Order.class)
                 .add(Restrictions.eq("userData", userData));
        List<Order> orderList = criteria.list();
        return orderList;
    }



}
