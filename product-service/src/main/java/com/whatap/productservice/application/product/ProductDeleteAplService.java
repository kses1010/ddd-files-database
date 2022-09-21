package com.whatap.productservice.application.product;

import com.whatap.productservice.application.product.command.ProductDeleteCommand;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductDeleteAplService {

    @Transactional
    public void deleteProduct(ProductDeleteCommand command) {

    }
}
