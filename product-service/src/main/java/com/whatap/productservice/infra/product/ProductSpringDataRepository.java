package com.whatap.productservice.infra.product;

import com.whatap.productservice.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductSpringDataRepository extends JpaRepository<Product, Long> {

}
