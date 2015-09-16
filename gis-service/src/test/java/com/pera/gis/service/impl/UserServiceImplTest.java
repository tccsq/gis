package com.pera.gis.service.impl;

import com.pera.gis.data.model.User;
import com.pera.gis.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by csq on 2015/9/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/dev/spring/spring-service-config.xml"})
public class UserServiceImplTest {
    @Autowired
    private UserService userService;
    @Test
    public void testSave(){
        User user = new User();
        user.setName("张三");
        user.setPassword("123");
        user.setUsername("test");

        userService.save(user);
    }
}