package com.springboot.graphql.controller;

import com.springboot.graphql.entity.Order;
import com.springboot.graphql.entity.User;
import com.springboot.graphql.service.OrderService;
import com.springboot.graphql.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderRestController {

    private final OrderService orderService;

    private  final UserService userService;

    @MutationMapping
    public Order createOrder(@Argument String orderDetail, @Argument Double price, @Argument Long userId){
        Order order =new Order();
        order.setOrderDetail(orderDetail);
        order.setPrice(price);
        order.setUser(userService.getUser(userId));
        return orderService.createOrder(order);
    }

    @QueryMapping
    public List<Order> getAllOrder(){
        return orderService.getAllOrder();
    }

    @QueryMapping
    public  Order getOrder(@Argument Long orderId){

        return  orderService.getOrder(orderId);
    }

    @MutationMapping
    public  boolean deleteOrder(@Argument Long orderId){

        return  orderService.deleteByOrderId(orderId);
    }
}
