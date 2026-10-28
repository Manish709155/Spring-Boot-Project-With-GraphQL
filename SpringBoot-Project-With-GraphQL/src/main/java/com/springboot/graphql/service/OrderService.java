package com.springboot.graphql.service;

import com.springboot.graphql.entity.Order;

import java.util.List;

public interface OrderService {

    Order createOrder(Order order);

    List<Order> getAllOrder();

    Order getOrder(Long orderId);

    public  boolean deleteByOrderId(Long orderId);
}
