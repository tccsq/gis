package com.pera.gis.data.dao.impl;

import com.pera.gis.data.dao.BaseDao;
import com.pera.gis.data.model.CommonEntity;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Created by csq on 2015/10/12.
 */
public class BaseDaoImpl<T extends CommonEntity<ID>, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseDao<T, ID> {

    public BaseDaoImpl(JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
    }
}
