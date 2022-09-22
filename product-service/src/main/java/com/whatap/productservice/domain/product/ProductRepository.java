package com.whatap.productservice.domain.product;

import com.whatap.productservice.global.pagination.PageQuery;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Product save(Product product);

    Optional<Product> findById(Long id);

    List<Product> findAll();

    List<Product> findAll(PageQuery pageQuery);

    List<Product> findAll(List<Long> ids);

    void delete(Product product);
}
