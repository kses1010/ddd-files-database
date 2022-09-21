package com.whatap.productservice.application.product;

import com.whatap.productservice.application.product.command.ProductDeleteCommand;
import com.whatap.productservice.domain.product.Product;
import com.whatap.productservice.domain.product.ProductRepository;
import com.whatap.productservice.domain.product.exception.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ProductDeleteAplService {

    private final ProductRepository productRepository;

    @Transactional
    public void deleteProduct(ProductDeleteCommand command) {
        Product product = productRepository.findById(command.getId()).orElseThrow(ProductNotFoundException::new);
        productRepository.delete(product);
    }
}
