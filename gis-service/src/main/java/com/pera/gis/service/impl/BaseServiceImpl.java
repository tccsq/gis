package com.pera.gis.service.impl;

import com.pera.gis.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by csq on 2015/9/16.
 */
public class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T,ID> {
    @Autowired
    private CrudRepository<T,ID> dao;

    @Transactional
    @Override
    public <S extends T> S save(S obj) {
        return dao.save(obj);
    }

    @Override
    public T findOne(ID id) {
        return null;
    }

    @Override
    public T findOne(T t) {
        return null;
    }

    @Override
    public boolean exists(ID id) {
        return false;
    }

    @Override
    public Page<T> findPage(T t, Pageable pageable) {
        return null;
    }

    @Override
    public List<T> find(T t) {
        return null;
    }

    @Override
    public Iterable<T> findAll() {
        return null;
    }
}
