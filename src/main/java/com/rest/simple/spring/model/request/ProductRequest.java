package com.rest.simple.spring.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    @NotBlank(message = "product name must be not blank")
    private String name;

    @NotNull(message = "product price must be specified")
    @DecimalMin(value = "0.0", message = "product price can't be less than zero")
    private BigDecimal price;

    //Depends on conditions other validations like @Past could be added
    @NotNull(message = "product date must be specified")
    private Instant date;
}
