package com.pera.gis.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by csq on 2015/9/16.
 */
public interface BaseService<T, ID extends Serializable> {

    <S extends T> S save(S obj);

    T findOne(ID id);

    T findOne(T t);

    boolean exists(ID id);

    Page<T> findPage(T t, Pageable pageable);

    List<T> find(T t);

    Iterable<T> findAll();

}
