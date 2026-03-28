package com.sparta.orderservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter ///데이터를 가져온다 get
@NoArgsConstructor /// 파라미터가 없는 기본 생성자를 만든다


public class OrderRequestDto {
    private Long productId; /// 주문한 상품 ID
}
