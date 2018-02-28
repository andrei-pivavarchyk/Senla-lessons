package com.service;

import com.daoAPI.IOrderDAO;
import com.daoAPI.IUserDataDAO;
import com.model.*;
import com.serviceAPI.IOrderService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrderService implements IOrderService {

    private static Logger log = Logger.getLogger(OrderService.class);

    @Autowired
    private IOrderDAO orderDAO;
    @Autowired
    private IUserDataDAO userDataDao;

    @Override
    public List<Order> getAllOrders() {
        try {
            List<Order> orderList = this.orderDAO.getAllOrders();
            return orderList;
        } catch (Exception e) {
            log.error(e.toString());
            return null;
        }
    }



    @Override
    public void createOrder(UserData userData, List<Book> bookList) {
        Order order = new Order();

        Address address = userData.getAddress();
        if (address.getCity() != null
                && address.getCountry() != null
                && address.getIndex() != null
                && address.getRegion() != null
                && address.getLocalAddress() != null
                ) {

            order.setCreationDate(new Date());
            order.setListOrderBooks(bookList);
            order.setOrderCost(this.getOrderCost(bookList));
            order.setOrderStatus(OrderStatus.DELIVERED);
            order.setUserData(userData);
            order.setOrderCost(this.getOrderCost(bookList));
            try {
                this.orderDAO.addEntity(order);
            } catch (Exception e) {
                log.error(e.toString());
            }
        }
    }

    public Integer getOrderCost(List<Book> bookList) {
        Integer cost = 0;
        for (Book book : bookList) {
            cost = cost + book.getBookCost();
        }
        return cost;
    }

    public void setOrderStatus(Integer orderID, OrderStatus status) {
        try {
            Order order = this.orderDAO.getEntityById(orderID);
            order.setOrderStatus(status);
            this.orderDAO.updateEntity(order);
        } catch (Exception e) {
            log.error(e.toString());
        }
    }

    public List<Order> getAllUserOrders(User user) {

        try {
            UserData userData = this.userDataDao.getDataByUser(user);
            List<Order> orderList = this.orderDAO.getAllOrdersByUser(userData);
            return orderList;
        } catch (Exception e) {
            log.error(e.toString());
            return null;
        }
    }


}