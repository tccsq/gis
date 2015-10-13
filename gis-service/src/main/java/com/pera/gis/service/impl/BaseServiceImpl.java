package com.pera.gis.service.impl;

import com.pera.gis.data.dao.BaseDao;
import com.pera.gis.data.model.CommonEntity;
import com.pera.gis.service.BaseService;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by csq on 2015/9/16.
 */
public class BaseServiceImpl<T extends CommonEntity<ID>, ID extends Serializable> implements BaseService<T,ID> {
    @Autowired
    private BaseDao<T,ID> dao;

    @Transactional
    @Override
    public <S extends T> S save(S obj) {
        return dao.save(obj);
    }

    @Override
    public T findOne(ID id) {
        return dao.findOne(id);
    }

    @Override
    public T findOne(T t) {
        Specification<T> spec = createSpec(t);

        return dao.findOne(spec);
    }


    @Override
    public boolean exists(ID id) {
        return dao.exists(id);
    }

    @Override
    public Page<T> findPage(T t, Pageable pageable) {

        Specification<T> spec = createSpec(t);
        return dao.findAll(spec,pageable);
    }

    private Specification<T> createSpec(T t){
        final List<Criterion> criterions = new ArrayList<Criterion>();
        final Map<String,Object> fieldMap = new HashMap<>();
        Class<? extends CommonEntity> clz = t.getClass();
        Field[] fields = clz.getDeclaredFields();

        for(Field f:fields){
            f.setAccessible(true);
            try {
                if(f.get(t) == null){
                    continue;
                }

                fieldMap.put(f.getName(),f.get(t));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        Specification<T> spec = new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                if (!criterions.isEmpty()) {
                    List<Predicate> predicates = new ArrayList<Predicate>();
                    //TODO 包含复杂对象属性的时候如何处理
                    for(String key:fieldMap.keySet()){
                        predicates.add(builder.equal(root.get(key), fieldMap.get(key)));
                    }

                    // 将所有条件用 and 联合起来
                    if (predicates.size() > 0) {
                        return builder.and(predicates.toArray(new Predicate[predicates.size()]));
                    }
                }
                return builder.conjunction();
            }
        };
        return spec;
    }


    @Override
    public List<T> find(T t) {
        return null;
    }

    @Override
    public Iterable<T> findAll() {
        return dao.findAll();
    }
}
