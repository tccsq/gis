package com.pera.gis.service.impl;

import com.pera.gis.data.model.User;
import com.pera.gis.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Created by csq on 2015/9/16.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User,Integer> implements UserService  {


    @Override
    public User findUserByUsername(String userName) {
        return null;
    }
}
