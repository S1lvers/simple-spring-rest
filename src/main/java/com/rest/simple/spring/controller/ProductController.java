package com.rest.simple.spring.controller;

import com.rest.simple.spring.model.request.ProductDeleteRequest;
import com.rest.simple.spring.model.request.ProductUpdateRequest;
import com.rest.simple.spring.model.request.ProductRequest;
import com.rest.simple.spring.model.response.ProductResponse;
import com.rest.simple.spring.services.product.ProductFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductFacade productFacade;

    @GetMapping
    public List<ProductResponse> getProducts() {
        return productFacade.getAll();
    }

    @GetMapping("/{id}")
    public ProductResponse getProduct(@PathVariable("id") UUID id) {
        return productFacade.getById(id);
    }

    @PostMapping
    public ProductResponse createProduct(@RequestBody @Valid ProductRequest productRequest) {
        return productFacade.create(productRequest);
    }

    @PutMapping
    public ProductResponse updateProduct(@RequestBody @Valid ProductUpdateRequest request) {
        return productFacade.update(request);
    }

    @DeleteMapping
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteProduct(@RequestBody @Valid ProductDeleteRequest request) {
        productFacade.delete(request);
    }
}
