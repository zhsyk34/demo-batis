package com.cat.demo.entity;

/**
 * Created by Archimedes on 2016/6/26. 房客(租客),简单指向userId(因此userId不能重复),暂无其余信息...
 */
public class Tenant {

	private int id;

	private int userId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
