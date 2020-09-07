package com.rest.simple.spring.db.repository;

import com.rest.simple.spring.db.entity.Product;

import java.util.UUID;

public interface ProductRepository extends EntityRepository<Product, UUID> {

}
