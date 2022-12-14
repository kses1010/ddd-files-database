package com.whatap.productservice.application.product;

import com.whatap.productservice.application.product.query.ProductDetailQuery;
import com.whatap.productservice.application.product.query.ProductListByOrdersQuery;
import com.whatap.productservice.application.product.query.ProductListQuery;
import com.whatap.productservice.domain.product.Product;
import com.whatap.productservice.domain.product.ProductRepository;
import com.whatap.productservice.domain.product.exception.ProductNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class ProductReadAplService {

    private final ProductRepository productRepository;

    public Product getProductDetail(ProductDetailQuery query) {
        return productRepository.findById(query.getId()).orElseThrow(ProductNotFoundException::new);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProducts(ProductListQuery query) {
        return productRepository.findAll(query.getPageQuery());
    }

    public List<Product> getProducts(ProductListByOrdersQuery query) {
        return productRepository.findAll(query.getIds());
    }
}
