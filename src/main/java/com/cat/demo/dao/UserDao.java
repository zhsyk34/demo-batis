package com.cat.demo.dao;

import com.cat.demo.entity.User;

import java.util.List;

/**
 * Created by Archimedes on 2016/6/25.
 */
public interface UserDao {

	int save(User user);

	int delete(int id);

	int delete(int[] ids);

	int delete(User user);

	int delete(List<User> users);

	int update(User user);

	User find(int id);

	List<User> findList(String name, String sort, String order, int offset, int length);

	int count(String name);

}
