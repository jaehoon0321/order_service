package com.sparta.orderservice.dto;

import com.sparta.orderservice.entity.Order;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class OrderResponseDto {
    private Long id; ///id
    private String productName; ///상품 이름
    private Integer productPrice;/// 상품 가격
    private LocalDateTime createdAt;///만든 날자

    public OrderResponseDto(Order order) {
        this.id = order.getId();
        /// 상품의 가장 최신 이름을 가져옴,엔티티를 데이터에서 클라이언틍에 보내주고 응답할 때만 디비값에서 이름을 던져줌
        /*상품 수정에서 상품 이름을 변경했을 때, 해당 상품으로 이미 생성된 주문을 조회하면 주문 조회 결과의 상품 이름도 변경된 이름으로 보여야 합니다.*/
        this.productName = order.getProduct().getName();
        this.productPrice = order.getProduct().getPrice();
        this.createdAt = order.getCreatedAt();
    }
}
