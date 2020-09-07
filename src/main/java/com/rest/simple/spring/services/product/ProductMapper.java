package com.rest.simple.spring.services.product;

import com.rest.simple.spring.db.entity.Product;
import com.rest.simple.spring.model.request.ProductUpdateRequest;
import com.rest.simple.spring.model.request.ProductRequest;
import com.rest.simple.spring.model.response.ProductResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductMapper {

    public static ProductResponse from(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(String.valueOf(product.getId()));
        productResponse.setName(product.getName());
        productResponse.setPrice(product.getPrice());
        productResponse.setDate(product.getDate());
        return productResponse;
    }

    public static Product toEntity(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setDate(productRequest.getDate());
        return product;
    }

    public static Product toEntityWithId(ProductUpdateRequest request) {
        Product product = toEntity(request);
        product.setId(request.getId());
        return product;
    }
}
