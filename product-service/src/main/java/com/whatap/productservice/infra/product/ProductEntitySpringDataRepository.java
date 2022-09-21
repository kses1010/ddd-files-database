package com.whatap.productservice.infra.product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductEntitySpringDataRepository extends JpaRepository<ProductEntity, Long> {

}
