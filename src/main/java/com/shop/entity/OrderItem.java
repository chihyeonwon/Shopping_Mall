package com.shop.entity;

import lombok.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Getter @Setter
@Entity
@Table(name="order_item")
public class OrderItem extends BaseEntity {

    @Id @GeneratedValue
    @Column(name="order_item_id")
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="item_id")
    private Item item;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="order_id")
    private Order order;

    private int orderPrice; // 주문가격

    private int count; // 수량
}
