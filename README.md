상품 생성 테스트 
<img width="1403" height="746" alt="image" src="https://github.com/user-attachments/assets/d2b54fb2-2340-4f04-9ffe-b065ba15bed8" />
<img width="1410" height="466" alt="image" src="https://github.com/user-attachments/assets/9a7309e4-f564-4f67-b658-ff7fe15c017e" />

주문 생성 테스트
<img width="1397" height="828" alt="image" src="https://github.com/user-attachments/assets/2907ea97-52b1-4c6f-851f-2b58ee78c6bb" />
<img width="1414" height="624" alt="image" src="https://github.com/user-attachments/assets/d32bde51-2703-4e9a-94bd-7f5e67e0dfca" />

상품 이름 변경시 주문 내역 업데이트
<img width="1398" height="1412" alt="image" src="https://github.com/user-attachments/assets/bfab2316-9775-4c6c-87bf-de7c86cd20c4" />

페이지 네이션 주문 목록 조회
<img width="1003" height="1357" alt="image" src="https://github.com/user-attachments/assets/92337505-52c7-4825-b084-760c2d60e035" />
2026-03-29T00:05:54.061+09:00  WARN 5584 --- [miniwms] [nio-8080-exec-2] ration$PageModule$WarningLoggingModifier : Serializing PageImpl instances as-is is not supported, meaning that there is no guarantee about the stability of the resulting JSON structure!
	For a stable JSON structure, please use Spring Data's PagedModel (globally via @EnableSpringDataWebSupport(pageSerializationMode = VIA_DTO))
	or Spring HATEOAS and Spring Data's PagedResourcesAssembler as documented in https://docs.spring.io/spring-data/commons/reference/repositories/core-extensions.html#core.web.pageables.

Hibernate: 
    select
        o1_0.id,
        o1_0.created_at,
        o1_0.product_id,
        p1_0.id,
        p1_0.name,
        p1_0.price 
    from
        orders o1_0 
    join
        product p1_0 
            on p1_0.id=o1_0.product_id 
    order by
        o1_0.created_at desc 
    limit
        ?
Hibernate: 
    select
        p1_0.id,
        p1_0.name,
        p1_0.price 
    from
        product p1_0 
    where
        p1_0.id=?
Hibernate: 
    insert 
    into
        orders
        (created_at, product_id) 
    values
        (?, ?)
Hibernate: 
    select
        p1_0.id,
        p1_0.name,
        p1_0.price 
    from
        product p1_0 
    where
        p1_0.id=?
Hibernate: 
    insert 
    into
        orders
        (created_at, product_id) 
    values
        (?, ?)
Hibernate: 
    select
        p1_0.id,
        p1_0.name,
        p1_0.price 
    from
        product p1_0 
    where
        p1_0.id=?
Hibernate: 
    insert 
    into
        orders
        (created_at, product_id) 
    values
        (?, ?)
Hibernate: 
    select
        p1_0.id,
        p1_0.name,
        p1_0.price 
    from
        product p1_0 
    where
        p1_0.id=?
Hibernate: 
    insert 
    into
        orders
        (created_at, product_id) 
    values
        (?, ?)
Hibernate: 
    select
        p1_0.id,
        p1_0.name,
        p1_0.price 
    from
        product p1_0 
    where
        p1_0.id=?
Hibernate: 
    insert 
    into
        orders
        (created_at, product_id) 
    values
        (?, ?)
Hibernate: 
    select
        o1_0.id,
        o1_0.created_at,
        o1_0.product_id,
        p1_0.id,
        p1_0.name,
        p1_0.price 
    from
        orders o1_0 
    join
        product p1_0 
            on p1_0.id=o1_0.product_id 
    order by
        o1_0.created_at desc 
    limit
        ?
Hibernate: 
    select
        count(o1_0.id) 
    from
        orders o1_0
