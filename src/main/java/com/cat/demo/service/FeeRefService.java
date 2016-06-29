package com.cat.demo.service;

import java.util.Date;

import com.cat.demo.constant.DictEnum.FeeType;
import com.cat.demo.constant.DictEnum.GridType;
import com.cat.demo.entity.FeeRef;

public interface FeeRefService {

	// 根据日期查找物价表
	FeeRef find(int gridId, GridType gridType, FeeType feeType, Date date);
}
