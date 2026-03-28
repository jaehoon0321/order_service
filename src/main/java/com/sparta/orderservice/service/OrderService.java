package com.sparta.orderservice.service;

import com.sparta.orderservice.dto.OrderRequestDto;
import com.sparta.orderservice.dto.OrderResponseDto;
import com.sparta.orderservice.entity.Order;
import com.sparta.orderservice.entity.Product;
import com.sparta.orderservice.repository.OrderRepository;
import com.sparta.orderservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Transactional
    public OrderResponseDto createOrder(OrderRequestDto requestDto) {
        Product product = productRepository.findById(requestDto.getProductId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상품입니다."));

        Order order = Order.builder()
                .product(product)
                .build();

        Order savedOrder = orderRepository.save(order);
        return new OrderResponseDto(savedOrder);
    }

    @Transactional(readOnly = true)
    public OrderResponseDto getOrder(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("존재하지 않는 주문입니다.")
        );
        return new OrderResponseDto(order);
    }

    /// 주문 목록 조회 (페이징 + N+1 해결) 공부
    @Transactional(readOnly = true)
    public Page<OrderResponseDto> getOrdersList(int page, int size) {
        // page값(1부터 시작)을 0 변환해주고, 최신 주문순(createdAt 내림차순) 정렬 적용
        Pageable pageable = PageRequest.of(Math.max(0, page - 1), size, Sort.by(Sort.Direction.DESC, "createdAt"));
        
        Page<Order> orderPage = orderRepository.findProduct(pageable);
        
        return orderPage.map(OrderResponseDto::new);
    }
}
