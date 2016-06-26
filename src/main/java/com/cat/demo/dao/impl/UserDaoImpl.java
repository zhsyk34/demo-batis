package com.cat.demo.dao.impl;

import com.cat.demo.dao.BaseDao;
import com.cat.demo.dao.UserDao;
import com.cat.demo.entity.User;
import com.cat.demo.util.ArrayUtils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Archimedes on 2016/6/26.
 */
@Repository
public class UserDaoImpl extends BaseDao<User, Integer> implements UserDao {

	@Override
	public int save(User user) {
		return super.save(user);
	}

	@Override
	public int delete(int id) {
		return super.deleteById(id);
	}

	@Override
	public int delete(int[] ids) {
		return super.deleteByIds(ArrayUtils.toWrap(ids));
	}

	@Override
	public int delete(User user) {
		return super.deleteByEntity(user);
	}

	@Override
	public int delete(List<User> users) {
		return super.deleteByEntities(users);
	}

	@Override
	public int update(User user) {
		return super.update(user);
	}

	@Override
	public User find(int id) {
		return super.findById(id);
	}

	@Override
	public List<User> findList(String name, String sort, String order, int offset, int length) {
		Map<String, Object> map = new HashMap<>();

		if (StringUtils.isNotBlank(name)) {
			map.put("name", "%" + name + "%");
		}
		if (StringUtils.isNotBlank(sort) && StringUtils.isNotBlank(order)) {
			map.put("sort", sort);
			map.put("order", order);
		}
		if (offset >= 0 && length > 0) {
			map.put("offset", offset);
			map.put("length", length);
		}
		return super.findList(map);
	}

	@Override
	public int count(String name) {
		Map<String, Object> map = new HashMap<>();
		if (StringUtils.isNotBlank(name)) {
			map.put("name", "%" + name + "%");
		}
		return super.count(map);
	}
}
