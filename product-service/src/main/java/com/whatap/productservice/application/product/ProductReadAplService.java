package com.whatap.productservice.application.product;

import com.whatap.productservice.application.product.query.ProductDetailQuery;
import com.whatap.productservice.domain.product.Product;
import com.whatap.productservice.domain.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class ProductReadAplService {

    private final ProductRepository productRepository;
    
    public Product getProductDetail(ProductDetailQuery query) {
        // TODO: 2022/09/21  
    }
}
