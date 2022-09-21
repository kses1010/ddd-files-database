package com.whatap.productservice.presentation;

import com.whatap.productservice.application.product.ProductCreateAplService;
import com.whatap.productservice.application.product.ProductReadAplService;
import com.whatap.productservice.application.product.ProductUpdateAplService;
import com.whatap.productservice.application.product.command.ProductCreateCommand;
import com.whatap.productservice.application.product.command.ProductUpdateCommand;
import com.whatap.productservice.application.product.query.ProductDetailQuery;
import com.whatap.productservice.application.product.query.ProductListQuery;
import com.whatap.productservice.domain.product.Product;
import com.whatap.productservice.global.pagination.PageQuery;
import com.whatap.productservice.global.pagination.PageQueryDto;
import com.whatap.productservice.presentation.request.ProductCreateRequest;
import com.whatap.productservice.presentation.request.ProductUpdateRequest;
import com.whatap.productservice.presentation.response.ProductCreateResponse;
import com.whatap.productservice.presentation.response.ProductDetailResponse;
import com.whatap.productservice.presentation.response.ProductResponse;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/products")
@RestController
public class ProductController {

    private final ProductCreateAplService productCreateAplService;
    private final ProductReadAplService productReadAplService;
    private final ProductUpdateAplService productUpdateAplService;

    @PostMapping("")
    public ProductCreateResponse createProduct(@RequestBody @Valid ProductCreateRequest request) {
        Product product = productCreateAplService.createProduct(
            new ProductCreateCommand(request.getName(), request.getDescription()));
        return new ProductCreateResponse(product);
    }

    @GetMapping("/{id}")
    public ProductDetailResponse getProductDetail(@PathVariable Long id) {
        Product product = productReadAplService.getProductDetail(new ProductDetailQuery(id));
        return new ProductDetailResponse(product);
    }

    @GetMapping("/all")
    public List<ProductResponse> getAllProducts() {
        return productReadAplService.getAllProducts().stream()
            .map(ProductResponse::new)
            .collect(Collectors.toList());
    }

    @GetMapping("")
    public List<ProductResponse> getProducts(@ModelAttribute @Valid PageQueryDto pageQueryDto) {
        PageQuery pageQuery = new PageQuery(pageQueryDto.getPage(), pageQueryDto.getLimit());
        return productReadAplService.getProducts(new ProductListQuery(pageQuery)).stream()
            .map(ProductResponse::new)
            .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public ProductDetailResponse updateProduct(
        @PathVariable Long id,
        @RequestBody @Valid ProductUpdateRequest request) {

        Product product = productUpdateAplService.updateProduct(
            new ProductUpdateCommand(id, request.getName(), request.getDescription()));
        return new ProductDetailResponse(product);
    }
}
