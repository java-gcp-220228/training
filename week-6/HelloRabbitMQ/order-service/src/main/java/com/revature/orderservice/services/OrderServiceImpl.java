package com.revature.orderservice.services;

import com.revature.orderservice.models.Order;
import com.revature.orderservice.repositories.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order createNewOrder(Order order) {
        return orderRepository.save(order);
    }
}
