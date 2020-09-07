package com.rest.simple.spring.model.request;

import com.rest.simple.spring.services.product.ProductFacade;
import com.rest.simple.spring.validators.Existing;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class ProductUpdateRequest extends ProductRequest {

    @NotNull(message = "Product id must not be null")
    @Existing(facadeClass = ProductFacade.class, message = "Product with specified id doesn't exist")
    private UUID id;
}
