package com.twg.service;

/**
 * Created by tenvin on 2017/7/26.
 */
public interface BaseService <T,ID>{
    public T get(ID id);

    public T save(T t);

    public void delete(ID id);
}
