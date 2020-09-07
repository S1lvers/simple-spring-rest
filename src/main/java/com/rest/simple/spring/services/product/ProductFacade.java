package com.rest.simple.spring.services.product;

import com.rest.simple.spring.db.entity.Product;
import com.rest.simple.spring.exceptions.EntityNotFoundException;
import com.rest.simple.spring.model.request.ProductDeleteRequest;
import com.rest.simple.spring.model.request.ProductUpdateRequest;
import com.rest.simple.spring.model.request.ProductRequest;
import com.rest.simple.spring.model.response.ProductResponse;
import com.rest.simple.spring.services.BasicFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Slf4j
@Service
@RequiredArgsConstructor
public class ProductFacade implements BasicFacade {

    private final ProductDbService productDbService;

    public List<ProductResponse> getAll() {
        return productDbService.findAll()
                .stream()
                .map(ProductMapper::from)
                .collect(Collectors.toList());
    }

    public ProductResponse getById(UUID id) {
        return productDbService.findById(id)
                .map(ProductMapper::from)
                .orElseThrow(() -> new EntityNotFoundException(Product.class, id.toString()));
    }

    public ProductResponse create(ProductRequest productRequest) {
        var entity = ProductMapper.toEntity(productRequest);
        var savedEntity = productDbService.create(entity);
        return ProductMapper.from(savedEntity);
    }

    public ProductResponse update(ProductUpdateRequest request) {
        var entity = ProductMapper.toEntityWithId(request);
        var updatedEntity = productDbService.update(entity);
        return ProductMapper.from(updatedEntity);
    }

    public void delete(ProductDeleteRequest request) {
        var entity = productDbService.findById(request.getId());
        entity.ifPresent(productDbService::delete);
    }

    @Override
    public boolean existsById(Object id) {
        return productDbService.existById(id);
    }
}
