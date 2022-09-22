package com.whatap.orderservice.infra.product.dto.result;

import com.whatap.orderservice.domain.order.model.ProductDetail;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResult {

    private Long id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ProductResult() {
    }

    public ProductDetail toProductDetail() {
        return new ProductDetail(id, name, description);
    }
}
