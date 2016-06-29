package com.cat.demo.dao;

import java.util.List;
import java.util.Map;

import com.cat.demo.entity.Room;

/**
 * Created by Archimedes on 2016/6/26.
 */
public interface RoomDao {

	int save(Room room);

	int update(Room room);

	Room find(int id);

	List<Room> findList(int houseId, String name, Boolean used, String sort, String order, int offset, int length);

	List<Room> findList(int houseId, String name, Boolean used);

	int count(int houseId, String name, Boolean used);

	List<Room> findList(int houseId);

	List<Map<String, Object>> findListWithFee(int houseId, String name, Boolean used);

}
