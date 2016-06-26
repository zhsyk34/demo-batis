package com.cat.demo.entity;

import java.util.Date;

/**
 * Created by Archimedes on 2016/6/25.
 */
public class User {

	private int id;

	private String name;

	private Date birthday;

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User{" + "birthday=" + birthday + ", id=" + id + ", name='" + name + '\'' + '}';
	}
}
