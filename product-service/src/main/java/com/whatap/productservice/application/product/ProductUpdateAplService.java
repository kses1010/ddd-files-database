package com.whatap.productservice.application.product;

import com.whatap.productservice.application.product.command.ProductUpdateCommand;
import com.whatap.productservice.domain.product.Product;
import com.whatap.productservice.domain.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ProductUpdateAplService {

    private final ProductRepository productRepository;

    @Transactional
    public Product updateProduct(ProductUpdateCommand command) {

    }
}
