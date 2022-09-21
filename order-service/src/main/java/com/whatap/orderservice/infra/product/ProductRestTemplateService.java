package com.whatap.orderservice.infra.product;

import com.whatap.orderservice.domain.order.exception.ProductResultNotFoundException;
import com.whatap.orderservice.domain.order.model.ProductDetail;
import com.whatap.orderservice.domain.order.service.ProductService;
import com.whatap.orderservice.infra.product.dto.ProductResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductRestTemplateService implements ProductService {

    private final RestTemplate restTemplate;

    @Override
    public ProductDetail getProductDetail(Long productId) {
        try {
            ProductResult productResult = restTemplate.getForObject(
                "http://localhost:8082/products/${productId}",
                ProductResult.class);
            if (productResult == null) {
                throw new ProductResultNotFoundException();
            }
            return productResult.toProductDetail();
        } catch (HttpClientErrorException.NotFound e) {
            log.error("HttpClientErrorException.NotFound");
            throw new ProductResultNotFoundException();
        }
    }
}
