package com.pera.gis.data.dao;

import com.pera.gis.data.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by csq on 2015/9/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/dev/spring/spring-data-config.xml"})
public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void testSave() {
        User user = new User();
        user.setName("张三");
        user.setPassword("123");
        user.setUsername("test");

        userDao.save(user);
    }
}