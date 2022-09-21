package com.whatap.productservice.application.product;

import com.whatap.productservice.application.product.command.ProductCreateCommand;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateProductAplService {

    @Transactional
    public void createProduct(ProductCreateCommand command) {

    }
}
