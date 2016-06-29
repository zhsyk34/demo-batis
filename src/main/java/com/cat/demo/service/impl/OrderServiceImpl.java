package com.cat.demo.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Service;

import com.cat.demo.constant.DictEnum.GridType;
import com.cat.demo.constant.DictEnum.OrderStatus;
import com.cat.demo.constant.DictEnum.RentState;
import com.cat.demo.dao.HouseDao;
import com.cat.demo.dao.OrderDao;
import com.cat.demo.dao.OrderDetailDao;
import com.cat.demo.dao.RoomDao;
import com.cat.demo.entity.House;
import com.cat.demo.entity.Order;
import com.cat.demo.entity.OrderDetail;
import com.cat.demo.entity.Room;
import com.cat.demo.service.OrderService;

/**
 * Created by Archimedes on 2016/6/26.
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Resource
	private OrderDao orderDao;
	@Resource
	private OrderDetailDao orderDetailDao;
	@Resource
	private HouseDao houseDao;
	@Resource
	private RoomDao roomDao;

	@Override
	public boolean save(Order order, List<OrderDetail> orderDetails) {
		orderDao.save(order);
		int orderId = order.getId();
		if (CollectionUtils.isNotEmpty(orderDetails)) {
			orderDetails.forEach(orderDetail -> {
				orderDetail.setOrderId(orderId);
				orderDetailDao.save(orderDetail);
			});
		}
		return true;
	}

	@Override
	public boolean save(int houseId, int tenantId, int[] roomIds, GridType gridType, Date begin, Date end) {
		// 1.验证数据,是否已经出租等...
		// 1-1.
		if (houseId <= 0 || ArrayUtils.isEmpty(roomIds)) {
			return false;
		}
		// 1-2.
		House house = houseDao.find(houseId);
		if (house == null || house.isUsed()) {
			return false;
		}
		// 1-3.与业务的托管类型校对
		switch (house.getRentState()) {
		case BOTH:
			house.setRentState(RentState.SINGLE);// 出租部分后只允许单租
			break;
		case WHOLE:
			if (gridType == GridType.ROOM) {
				return false;// 只支持整租
			}
			break;
		case SINGLE:
			break;
		case STOP:
			return false;// 业主已冻结...

		}
		// 1-4.如果为整租时,room必须全部...
		if (gridType == GridType.HOUSE) {
			int count = roomDao.count(houseId, null, false);
			if (count != roomIds.length) {
				return false;
			}
		}
		// 1-5.
		for (int i = 0; i < roomIds.length; i++) {
			int roomId = roomIds[i];
			Room room = roomDao.find(roomId);
			if (room == null || room.isUsed()) {
				return false;
			}
			room.setUsed(true);
			roomDao.update(room);
		}

		// 2.保存父订单
		Order order = new Order();

		order.setOrderNo("20160701-00103");// 模拟...
		order.setTenantId(tenantId);

		order.setHouseId(houseId);
		order.setGridType(gridType);

		order.setBegin(begin);
		order.setEnd(end);
		order.setHappen(new Date());
		order.setStatus(OrderStatus.DEBT);//

		orderDao.save(order);

		// 3.子订单
		int orderId = order.getId();
		OrderDetail orderDetail;
		for (int i = 0; i < roomIds.length; i++) {
			orderDetail = new OrderDetail();
			orderDetail.setOrderId(orderId);
			orderDetail.setRoomId(roomIds[i]);

			orderDetailDao.save(orderDetail);
		}

		// 4.修改House状态,改变used + state(1-4)
		boolean houseUsed = true;
		List<Room> rooms = roomDao.findList(houseId);
		for (Room room : rooms) {
			if (!room.isUsed()) {
				houseUsed = false;
				break;
			}
		}
		System.out.println(houseUsed);
		house.setUsed(houseUsed);
		houseDao.update(house);

		return true;
	}

}
