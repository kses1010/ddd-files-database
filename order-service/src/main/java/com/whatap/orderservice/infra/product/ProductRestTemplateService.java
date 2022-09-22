package com.whatap.orderservice.infra.product;

import com.whatap.orderservice.domain.order.exception.ProductResultFailException;
import com.whatap.orderservice.domain.order.exception.ProductResultNotFoundException;
import com.whatap.orderservice.domain.order.model.ProductDetail;
import com.whatap.orderservice.domain.order.service.ProductService;
import com.whatap.orderservice.infra.product.dto.request.ProductByOrdersRequest;
import com.whatap.orderservice.infra.product.dto.result.ProductByOrdersResult;
import com.whatap.orderservice.infra.product.dto.result.ProductResult;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
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
                "http://localhost:8082/products/" + productId,
                ProductResult.class);
            if (productResult == null) {
                throw new ProductResultNotFoundException();
            }
            return productResult.toProductDetail();
        } catch (HttpClientErrorException.NotFound e) {
            log.error("HttpClientErrorException.NotFound");
            throw new ProductResultNotFoundException();
        } catch (HttpClientErrorException e) {
            log.error("HttpClientErrorException Internal Server Error Exception");
            throw new ProductResultFailException();
        }
    }

    @Override
    public List<ProductDetail> getProducts(List<Long> productIds) {
        try {
            ProductByOrdersResult productByOrdersResult = restTemplate.postForObject(
                "http://localhost:8082/products/info",
                new ProductByOrdersRequest(productIds),
                ProductByOrdersResult.class
            );
            if (productByOrdersResult == null || productByOrdersResult.getProductResults().isEmpty()) {
                return Collections.emptyList();
            }
            return productByOrdersResult.getProductResults().stream()
                .map(ProductResult::toProductDetail)
                .collect(Collectors.toList());
        } catch (HttpClientErrorException e) {
            log.error("HttpClientErrorException Internal Server Error Exception");
            throw new ProductResultFailException();
        }
    }
}
