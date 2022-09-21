package com.whatap.productservice.infra.product;

import com.whatap.productservice.domain.product.Product;
import com.whatap.productservice.domain.product.ProductRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductEntitySpringDataRepository productEntitySpringDataRepository;

    @Override
    public Product save(Product product) {
        return productEntitySpringDataRepository.save(product.toEntity()).toDomain();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productEntitySpringDataRepository.findById(id).map(ProductEntity::toDomain);
    }
}
