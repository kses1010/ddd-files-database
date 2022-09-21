package com.whatap.productservice.presentation;

import com.whatap.productservice.application.product.ProductCreateAplService;
import com.whatap.productservice.application.product.ProductReadAplService;
import com.whatap.productservice.application.product.command.ProductCreateCommand;
import com.whatap.productservice.application.product.query.ProductDetailQuery;
import com.whatap.productservice.domain.product.Product;
import com.whatap.productservice.presentation.request.ProductCreateRequest;
import com.whatap.productservice.presentation.response.ProductCreateResponse;
import com.whatap.productservice.presentation.response.ProductDetailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/products")
@RestController
public class ProductController {

    private final ProductCreateAplService productCreateAplService;
    private final ProductReadAplService productReadAplService;

    @PostMapping("")
    public ProductCreateResponse createProduct(@RequestBody ProductCreateRequest request) {
        Product product = productCreateAplService.createProduct(
            new ProductCreateCommand(request.getName(), request.getDescription()));
        return new ProductCreateResponse(product);
    }

    @GetMapping("/{id}")
    public ProductDetailResponse getProductDetail(@PathVariable Long id) {
        Product product = productReadAplService.getProductDetail(new ProductDetailQuery(id));
        return new ProductDetailResponse(product);
    }
}
