package com.rest.simple.spring.model.response;

import com.rest.simple.spring.db.entity.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
public class ProductResponse {

    private String id;

    private String name;

    private BigDecimal price;

    private Instant date;
}
