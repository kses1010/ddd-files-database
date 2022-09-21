package com.whatap.productservice.application.product;

import com.whatap.productservice.application.product.command.ProductCreateCommand;
import com.whatap.productservice.domain.product.Product;
import com.whatap.productservice.domain.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ProductCreateAplService {

    private final ProductRepository productRepository;

    @Transactional
    public Product createProduct(ProductCreateCommand command) {
        Product product = Product.createProduct(command.getName(), command.getDescription());
        productRepository.save(product);
    }
}
