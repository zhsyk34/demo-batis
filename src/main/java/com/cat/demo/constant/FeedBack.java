package com.cat.demo.constant;

//反馈给页面的信息
public enum FeedBack {

	SUCCESS, FAIL, ERROR, WARNING;

	@Override
	public String toString() {
		return super.toString().toLowerCase();
	}

}
