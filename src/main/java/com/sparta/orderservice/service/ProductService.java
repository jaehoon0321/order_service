package com.sparta.orderservice.service;

import com.sparta.orderservice.dto.ProductRequestDto;
import com.sparta.orderservice.dto.ProductResponseDto;
import com.sparta.orderservice.entity.Product;
import com.sparta.orderservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public ProductResponseDto createProduct(ProductRequestDto requestDto) {
        Product product = Product.builder()
                .name(requestDto.getName())
                .price(requestDto.getPrice())
                .build();
        Product savedProduct = productRepository.save(product);
        return new ProductResponseDto(savedProduct);
    }

    @Transactional(readOnly = true)
    public List<ProductResponseDto> getProducts() {
        return productRepository.findAll().stream()
                .map(ProductResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProductResponseDto getProduct(Long id) {
        Product product = findProduct(id);
        return new ProductResponseDto(product);
    }

    @Transactional
    public ProductResponseDto updateProduct(Long id, ProductRequestDto requestDto) {
        Product product = findProduct(id);

        product.update(requestDto.getName(), requestDto.getPrice());
        return new ProductResponseDto(product);
    }

    @Transactional
    public void deleteProduct(Long id) {
        Product product = findProduct(id);
        productRepository.delete(product);
    }

    /// 중복으로 사용되는 예외 처리
    private Product findProduct(Long id) {
        return productRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 상품은 존재하지 않음")
        );
    }
}
