package com.cat.demo.dao.impl;

import com.cat.demo.dao.BaseDao;
import com.cat.demo.dao.OrderDetailDao;
import com.cat.demo.entity.OrderDetail;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Archimedes on 2016/6/26.
 */
@Repository
public class OrderDetailDaoImpl extends BaseDao<OrderDetail, Integer> implements OrderDetailDao {

	@Override
	public OrderDetail find(int id) {
		return super.findById(id);
	}

	@Override
	public List<OrderDetail> findList(int orderId, int roomId) {
		Map<String, Object> map = new HashMap<>();
		if (orderId > 0) {
			map.put("orderId", orderId);
		}
		if (roomId > 0) {
			map.put("roomId", roomId);
		}

		return super.findList(map);
	}

	@Override
	public List<OrderDetail> findList(int orderId) {
		return this.findList(orderId, -1);
	}
}
