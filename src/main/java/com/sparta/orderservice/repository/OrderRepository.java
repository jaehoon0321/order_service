package com.sparta.orderservice.repository;

import com.sparta.orderservice.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Long> {


    @Query(value = "select o from Order o join fetch o.product",
           countQuery = "select count(o) from Order o")
    Page<Order> findProduct(Pageable pageable);
}



/*
문제 상황 -> 주문 엔티티에서 100개를 조회 한뒤 각 주문의 상품 이름을 출력하면 상품을 가져오기 위해
추가로 100번이 실행이 되는데 이게 N+1 문제

해결 SOL -> Fetch Join  한번의JOIN 쿼리로 주문을 가져올 떄 연관된 상품 까지 한꺼번에 데이터를 다 긁어옴


* */
