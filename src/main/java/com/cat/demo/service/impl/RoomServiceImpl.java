package com.cat.demo.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cat.demo.dao.RoomDao;
import com.cat.demo.entity.Room;
import com.cat.demo.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {

	@Resource
	private RoomDao roomDao;

	@Override
	public List<Room> findList(int houseId) {
		return roomDao.findList(houseId, null, null);
	}

	@Override
	public List<Map<String, Object>> findListWithFee(int houseId, String name, Boolean used) {
		return roomDao.findListWithFee(houseId, name, used);
	}

	@Override
	public List<Map<String, Object>> findListWithFee(int houseId) {
		return roomDao.findListWithFee(houseId, null, null);
	}

}
