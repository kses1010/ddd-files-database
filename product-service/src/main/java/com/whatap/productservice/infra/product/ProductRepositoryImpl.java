package com.whatap.productservice.infra.product;

import com.whatap.productservice.domain.product.Product;
import com.whatap.productservice.domain.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductSpringDataRepository productSpringDataRepository;

    @Override
    public void save(Product product) {
        productSpringDataRepository.save(product);
    }
}
