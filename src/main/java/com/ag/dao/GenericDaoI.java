package com.ag.dao;

import com.xag.util.NoMatchFoundException;
import java.io.Serializable;
import java.util.List;

public interface GenericDaoI<T, PK extends Serializable> {

    T save(T t);

    T findById(PK id) throws NoMatchFoundException;

    T merge(T t);

    List<T> findAll();

    boolean remove(T t);

    int removeById(PK id);
}
