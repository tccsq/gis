package com.pera.gis.data.dao;

import com.pera.gis.data.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by csq on 2015/9/16.
 */
public interface UserDao extends CrudRepository<User,Integer> {
}
