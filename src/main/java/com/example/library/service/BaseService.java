package com.example.library.service;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class BaseService<T, ID> {

    protected final JpaRepository<T, ID> repository;

    public BaseService(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }
    
    /// 추상 클래스로 공통 로직 적용
    
    public T findById(ID id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Entity not found"));
    }

    public T save(T entity) {
        return repository.save(entity);
    }

    public void deleteById(ID id){
        repository.deleteById(id);
    }
}
