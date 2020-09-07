package com.rest.simple.spring.services.product;

import com.rest.simple.spring.db.entity.Product;
import com.rest.simple.spring.db.repository.ProductRepository;
import com.rest.simple.spring.services.DbService;
import org.springframework.stereotype.Service;

@Service
public class ProductDbService extends DbService<Product> {

    public ProductDbService(ProductRepository repository) {
        super(repository);
    }
}
