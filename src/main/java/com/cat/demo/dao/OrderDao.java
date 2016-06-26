package com.cat.demo.dao;

import com.cat.demo.constant.DictEnum;
import com.cat.demo.entity.Order;

import java.util.Date;
import java.util.List;

/**
 * Created by Archimedes on 2016/6/26.
 */
public interface OrderDao {

	int save(Order order);

	int delete(int id);

	int delete(int[] ids);

	int delete(Order order);

	int delete(List<Order> orders);

	int update(Order order);

	Order find(int id);

	List<Order> findList(String orderNo, int houseId, int tenantId, DictEnum.GridType gridType, Date date, DictEnum.OrderStatus status, String sort, String order, int offset, int length);

	List<Order> findList(String orderNo, int houseId, int tenantId, DictEnum.GridType gridType, Date date, DictEnum.OrderStatus status);

}
