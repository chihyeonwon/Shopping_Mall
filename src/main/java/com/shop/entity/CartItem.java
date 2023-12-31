package com.shop.entity;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name="cart_item")
@Getter @Setter
@ToString
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="cart_item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name="item_id")
    private Item item;

    private int count; // 같은 상품을 장바구니에 몇 개 담을 지 저장

}
