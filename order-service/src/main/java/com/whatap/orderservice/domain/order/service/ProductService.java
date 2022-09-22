package com.whatap.orderservice.domain.order.service;

import com.whatap.orderservice.domain.order.model.ProductDetail;
import java.util.List;

public interface ProductService {

    ProductDetail getProductDetail(Long productId);

    List<ProductDetail> getProducts(List<Long> productIds);
}
