package com.sparta.orderservice.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer price;

    @Builder
    public Product(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    /// 상품 정보 수정
    public void update(String name, Integer price) {
        this.name = name;
        this.price = price;
    }
}
