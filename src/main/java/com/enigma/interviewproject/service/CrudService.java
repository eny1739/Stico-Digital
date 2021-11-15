package com.enigma.interviewproject.service;

import java.util.List;

public interface CrudService<T> {
    public void create(T t);
    public List<T> findAll();
    public void deleteById(String id);
    public T getById(String id);
    public void update(T t);
}
