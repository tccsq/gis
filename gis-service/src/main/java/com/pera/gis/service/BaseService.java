package com.pera.gis.service;

import java.io.Serializable;

/**
 * Created by csq on 2015/9/16.
 */
public interface BaseService<T, ID extends Serializable> {

    <S extends T> S save(S obj);


}
