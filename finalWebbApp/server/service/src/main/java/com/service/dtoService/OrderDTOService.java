package com.service.dtoService;

import com.model.Order;
import com.serviceAPI.IOrderDTOService;

public class OrderDTOService implements IOrderDTOService {


    public Order getOrderDTO(Order order) {
        Order orderr = new Order();
        orderr.setId(order.getId());
        orderr.setOrderCost(order.getOrderCost());
        orderr.setOrderStatus(order.getOrderStatus());
        orderr.setUserData(order.getUserData());
        orderr.setCreationDate(order.getCreationDate());
        return orderr;
    }

}