package com.springboot.graphql.serviceImpl;

import com.springboot.graphql.entity.Order;
import com.springboot.graphql.entity.User;
import com.springboot.graphql.repository.OrderRepository;
import com.springboot.graphql.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private  final OrderRepository orderRepository;



    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrder(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(()->new RuntimeException("Order not found with given id: "+orderId));
    }

    @Override
    public boolean deleteByOrderId(Long orderId) {
        Order order =orderRepository.findById(orderId).orElseThrow(()->new RuntimeException("Order not found with given id: "+orderId));
        orderRepository.delete(order);
        return  true;
    }
}
