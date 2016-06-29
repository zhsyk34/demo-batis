package com.cat.demo.entity;

/**
 * Created by Archimedes on 2016/6/26
 * 房东,类似于租客...
 */
public class Landlord {

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

	@Override
	public String toString() {
		return "Landlord{" + "id=" + id + ", userId=" + userId + '}';
	}
}
