package de.ait.apirestevent.repository;

import de.ait.apirestevent.entity.Event;

import java.util.List;

public interface CrudRepository<T>{
    T findById(Long id);
    List<T> findAll();
    void save(T model);
    T deleteById(Long id);
    void update(T model);
}
