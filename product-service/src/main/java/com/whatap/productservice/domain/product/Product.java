package com.whatap.productservice.domain.product;

import com.whatap.productservice.infra.product.ProductEntity;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Product {

    private Long id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    protected Product() {

    }

    @Builder
    public Product(Long id, String name, String description, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public ProductEntity toEntity() {
        return ProductEntity.builder()
            .name(name)
            .description(description)
            .createdAt(createdAt)
            .updatedAt(updatedAt)
            .build();
    }

    public static Product createProduct(String name, String description) {
        return Product.builder()
            .name(name)
            .description(description)
            .createdAt(LocalDateTime.now())
            .build();
    }
}
