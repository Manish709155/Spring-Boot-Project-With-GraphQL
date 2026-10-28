package com.springboot.graphql.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "order_detail")
    String orderDetail;

    @Column(name = "price")
    Double price;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
}