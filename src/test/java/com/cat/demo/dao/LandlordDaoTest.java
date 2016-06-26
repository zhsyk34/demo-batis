package com.cat.demo.dao;

import com.cat.demo.entity.Landlord;
import com.cat.demo.entity.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import javax.annotation.Resource;

/**
 * Created by Archimedes on 2016/6/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class LandlordDaoTest {
    @Resource
    private LandlordDao landlordDao;
    @Resource
    private UserDao userDao;

    @Test
    public void save() throws Exception {
        List<User> users = userDao.findList("c", null, null, -1, -1);
        users.forEach(user -> {
            Landlord landlord = new Landlord();
            int userId = user.getId();
            landlord.setUserId(userId);

            System.out.println(landlordDao.save(landlord));
        });
    }

    @Test
    public void findList() throws Exception {
//        List<Landlord> landlords = landlordDao.findList(-1);
//        landlords.forEach(landlord -> System.out.println(landlord));
    }

    @Test
    public void count() throws Exception {

    }

}
