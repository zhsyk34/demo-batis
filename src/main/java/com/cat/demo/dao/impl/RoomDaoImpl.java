package com.cat.demo.dao.impl;

import com.cat.demo.dao.BaseDao;
import com.cat.demo.dao.RoomDao;
import com.cat.demo.entity.Room;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Archimedes on 2016/6/26.
 */
@Repository
public class RoomDaoImpl extends BaseDao<Room, Integer> implements RoomDao {

	@Override
	public int save(Room room) {
		return super.save(room);
	}

	@Override
	public int update(Room room) {
		return super.update(room);
	}

	@Override
	public Room find(int id) {
		return super.findById(id);
	}

	@Override
	public List<Room> findList(int houseId, String name, Boolean used, String sort, String order, int offset, int length) {
		Map<String, Object> map = new HashMap<>();
		if (houseId > 0) {
			map.put("houseId", houseId);
		}
		if (StringUtils.isNotBlank(name)) {
			map.put("name", name);
		}
		if (used != null) {
			map.put("used", used);
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
	public List<Room> findList(int houseId, String name, Boolean used) {
		return this.findList(houseId, name, used, null, null, -1, -1);
	}

	@Override
	public int count(int houseId, String name, Boolean used) {
		Map<String, Object> map = new HashMap<>();
		if (houseId > 0) {
			map.put("houseId", houseId);
		}
		if (StringUtils.isNotBlank(name)) {
			map.put("name", name);
		}
		if (used != null) {
			map.put("used", used);
		}
		return super.count(map);
	}
}
