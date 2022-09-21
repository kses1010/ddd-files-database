package com.whatap.orderservice.domain.order.service;

import com.whatap.orderservice.domain.order.model.ProductDetail;

public interface ProductService {

    ProductDetail getProductDetail(Long productId);
}
