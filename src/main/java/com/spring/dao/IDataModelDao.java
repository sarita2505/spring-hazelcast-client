package com.spring.dao;

import java.util.List;

public interface IDataModelDao<T,I> {
    I save(T model);
    T update(T model, I id);
    I delete(I id);
    List<T> find();
    T findById(I id);
}
