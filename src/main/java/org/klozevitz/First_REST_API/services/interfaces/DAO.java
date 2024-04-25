package org.klozevitz.First_REST_API.services.interfaces;

import jakarta.transaction.Transactional;

import java.util.List;

public interface DAO <T>{
    List<T> findAll();
    T findById(int id) throws Exception;
    T save(T t);
    @Transactional
    T update(T t);
    boolean deleteById(int id);
}
