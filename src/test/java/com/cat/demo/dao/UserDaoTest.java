package com.cat.demo.dao;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cat.demo.entity.User;

/**
 * Created by Archimedes on 2016/6/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml" })
public class UserDaoTest {

	@Resource
	private UserDao userDao;

	@Test
	public void save() throws Exception {
		User user;
		for (int i = 1; i < 3; i++) {
			user = new User();
			user.setName("name" + i);
			long offset = RandomUtils.nextLong(20 * 365, 30 * 365) * (1000 * 3600 * 24);
			Date date = new Date(System.currentTimeMillis() - offset);
			System.out.println(date);
			user.setBirthday(date);

			userDao.save(user);

			System.out.println(user.getId());
		}
	}

	@Test
	public void delete() throws Exception {
		userDao.delete(11);
	}

	@Test
	public void delete1() throws Exception {
		int[] ids = { 12, 17, 11 };
		userDao.delete(ids);
	}

	@Test
	public void delete2() throws Exception {
		User user = userDao.find(9);
		userDao.delete(user);
	}

	@Test
	public void delete3() throws Exception {
		List<User> users = userDao.findList("name", "birthday", "desc", -1, 2);
		userDao.delete(users);
	}

	@Test
	public void update() throws Exception {
		User user = userDao.find(2);
		user.setName("zsy");
		int result = userDao.update(user);
		System.out.println(result);
	}

	@Test
	public void find() throws Exception {
		System.out.println(userDao.find(7));
	}

	@Test
	public void findList() throws Exception {
		List<User> users = userDao.findList("3", "birthday", "desc", 1, 2);
		users.forEach(user -> System.out.println(user));
	}

	@Test
	public void count() throws Exception {
		System.out.println(userDao.count("3"));
	}

}
