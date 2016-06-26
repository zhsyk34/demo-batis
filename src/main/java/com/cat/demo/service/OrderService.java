package com.cat.demo.service;

import com.cat.demo.entity.Order;

import java.util.List;

/**
 * Created by Archimedes on 2016/6/26.
 */
public interface OrderService {

	List<Order> findList(int pageNo, int pageSize);

	int save(Order order);
}
