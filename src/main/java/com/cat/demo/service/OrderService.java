package com.cat.demo.service;

import java.util.Date;
import java.util.List;

import com.cat.demo.constant.DictEnum.GridType;
import com.cat.demo.entity.Order;
import com.cat.demo.entity.OrderDetail;

/**
 * Created by Archimedes on 2016/6/26.
 */
public interface OrderService {

	boolean save(Order order, List<OrderDetail> orderDetails);

	boolean save(int houseId, int tenantId, int[] roomIds, GridType gridType, Date begin, Date end);
}
