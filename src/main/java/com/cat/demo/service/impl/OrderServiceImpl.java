package com.cat.demo.service.impl;

import com.cat.demo.dao.OrderDao;
import com.cat.demo.dao.OrderDetailDao;
import com.cat.demo.entity.Order;
import com.cat.demo.service.OrderService;

import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.Resource;

/**
 * Created by Archimedes on 2016/6/26.
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Resource
	private OrderDao orderDao;
	@Resource
	private OrderDetailDao orderDetailDao;

	@Override
	public List<Order> findList(int pageNo, int pageSize) {
		return orderDao.findList(null, -1, -1, null, null, null, null, null, (pageNo - 1) * pageSize, pageSize);
	}

	@Override
	public int save(Order order) {
		return 0;
	}
}
