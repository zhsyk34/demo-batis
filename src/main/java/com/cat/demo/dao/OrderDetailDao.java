package com.cat.demo.dao;

import com.cat.demo.entity.OrderDetail;

import java.util.List;

/**
 * Created by Archimedes on 2016/6/26.
 */
public interface OrderDetailDao {

	int save(OrderDetail orderDetail);

	OrderDetail find(int id);

	List<OrderDetail> findList(int orderId, int roomId);

	List<OrderDetail> findList(int orderId);
}
