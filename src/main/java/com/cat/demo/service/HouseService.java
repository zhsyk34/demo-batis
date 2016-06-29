package com.cat.demo.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.cat.demo.constant.DictEnum;
import com.cat.demo.constant.DictEnum.RentState;
import com.cat.demo.entity.House;

public interface HouseService {

	// 查询房源
	List<House> findList(String name, RentState rentState, Boolean used);

	int count(String name, RentState rentState, Boolean used);

	List<Map<String, Object>> findListWithFee(String name, DictEnum.RentState rentState, Boolean used, Date date, String sort, String order, int pageNo, int pageSize);

}
