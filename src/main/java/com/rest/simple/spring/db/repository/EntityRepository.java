package com.rest.simple.spring.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface EntityRepository<E, ID> extends CrudRepository<E, ID> {

    @Override
    List<E> findAll();
}
