package com.cat.demo.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.cat.demo.constant.DictEnum;
import com.cat.demo.dao.BaseDao;
import com.cat.demo.dao.OrderDao;
import com.cat.demo.entity.Order;
import com.cat.demo.util.ArrayUtils;

/**
 * Created by Archimedes on 2016/6/26.
 */
@Repository
public class OrderDaoImpl extends BaseDao<Order, Integer> implements OrderDao {

	@Override
	public int save(Order order) {
		return super.save(order);
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
	public int delete(Order order) {
		return super.deleteByEntity(order);
	}

	@Override
	public int delete(List<Order> orders) {
		return super.deleteByEntities(orders);
	}

	@Override
	public int update(Order order) {
		return super.update(order);
	}

	@Override
	public Order find(int id) {
		return super.findById(id);
	}

	public List<Order> findList(String orderNo, int houseId, int tenantId, DictEnum.GridType gridType, Date date, DictEnum.OrderStatus status, String sort, String order, int offset, int length) {
		Map<String, Object> map = new HashMap<>();

		if (StringUtils.isNotBlank(orderNo)) {
			map.put("orderNo", orderNo);
		}
		if (houseId > 0) {
			map.put("houseId", houseId);
		}
		if (tenantId > 0) {
			map.put("tenantId", tenantId);
		}
		if (gridType != null) {
			map.put("gridType", gridType);
		}
		if (date != null) {
			map.put("date", date);
		}
		if (status != null) {
			map.put("status", status);
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
	public List<Order> findList(String orderNo, int houseId, int tenantId, DictEnum.GridType gridType, Date date, DictEnum.OrderStatus status) {

		return this.findList(orderNo, houseId, tenantId, gridType, date, status, null, null, -1, -1);
	}
}
