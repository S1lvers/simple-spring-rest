package com.rest.simple.spring.services;

import com.rest.simple.spring.db.repository.EntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//Every typical DbService must inherit this abstract db service to prevend code duplication
@Slf4j
public abstract class DbService<T> {

    protected final EntityRepository<T, Object> repository;

    public <R extends EntityRepository> DbService(R repository) {
        this.repository = repository;
    }

    public Optional<T> findById(Object id) {
        return repository.findById(id);
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    @Transactional
    public T update(T entity) {
        log.debug("update entity [{}]", entity.getClass().getSimpleName());
        return repository.save(entity);
    }

    @Transactional
    public T create(T entity) {
        log.debug("create entity [{}]", entity.getClass().getSimpleName());
        return repository.save(entity);
    }

    @Transactional
    public void delete(T entity) {
        log.debug("deleting entity [{}]", entity.getClass().getSimpleName());
        repository.delete(entity);
    }

    public boolean existById(Object id) {
        return repository.existsById(id);
    }
}
