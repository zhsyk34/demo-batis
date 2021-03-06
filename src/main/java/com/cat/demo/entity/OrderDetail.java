package com.cat.demo.entity;

//订单中涉及到的下级房源,这里简化为只处理house-room模式
public class OrderDetail {

	private int id;

	private int orderId;// 此处参照订单编号(不受订单状态改变的影响)

	private int roomId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
}
