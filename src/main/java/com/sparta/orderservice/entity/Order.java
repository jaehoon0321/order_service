package com.sparta.orderservice.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /// 주문 정보와 상품 정보는 각각 다른 테이블에 있지만 한주문에는 반드시 상품이 매핑이 되어야 하기 때문에
    /// ManyToOne 어노테이션으로 상품과 연결을 하고 LAZY로 지연 로딩을 설정 해둠(공부가 필요할 거 같음 )
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Builder
    public Order(Product product) {
        this.product = product;
        this.createdAt = LocalDateTime.now();
    }
}
