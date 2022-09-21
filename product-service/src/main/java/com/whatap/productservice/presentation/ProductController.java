package com.whatap.productservice.presentation;

import com.whatap.productservice.application.product.ProductCreateAplService;
import com.whatap.productservice.application.product.command.ProductCreateCommand;
import com.whatap.productservice.presentation.request.ProductCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/products")
@RestController
public class ProductController {

    private final ProductCreateAplService productCreateAplService;

    @PostMapping("")
    public void createProduct(@RequestBody ProductCreateRequest request) {
        productCreateAplService.createProduct(new ProductCreateCommand(request.getName(), request.getDescription()));
    }
}
