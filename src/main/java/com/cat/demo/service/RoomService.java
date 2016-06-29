package com.cat.demo.service;

import java.util.List;
import java.util.Map;

import com.cat.demo.entity.Room;

public interface RoomService {

	List<Room> findList(int houseId);

	List<Map<String, Object>> findListWithFee(int houseId, String name, Boolean used);

	List<Map<String, Object>> findListWithFee(int houseId);
}
