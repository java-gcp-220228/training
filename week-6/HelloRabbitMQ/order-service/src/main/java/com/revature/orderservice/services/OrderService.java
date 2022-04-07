package com.revature.orderservice.services;

import com.revature.orderservice.models.Order;

public interface OrderService {
    Order createNewOrder(Order order);
}
