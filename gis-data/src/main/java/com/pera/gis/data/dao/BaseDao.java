package com.pera.gis.data.dao;

import com.pera.gis.data.model.CommonEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * Created by csq on 2015/10/12.
 */
@NoRepositoryBean
public interface BaseDao<T extends CommonEntity<ID>, ID extends Serializable> extends PagingAndSortingRepository<T, ID> ,JpaSpecificationExecutor<T>{

}
