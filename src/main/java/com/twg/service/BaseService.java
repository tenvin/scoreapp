package com.twg.service;

import java.util.List;

/**
 * Created by tenvin on 2017/7/26.
 */
public interface BaseService <T,ID>{
    public T get(ID id);

    public T save(T t);

    public List<T> save(List<T> list);

    public void delete(ID id);

    public List<T> findAll();
}
