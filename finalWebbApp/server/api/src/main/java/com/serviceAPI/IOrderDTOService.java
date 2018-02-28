package com.serviceAPI;

import com.model.Order;

public interface IOrderDTOService {
    Order getOrderDTO(Order order);
}