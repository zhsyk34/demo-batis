package com.cat.demo.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cat.demo.constant.DictEnum.RentState;
import com.cat.demo.dao.HouseDao;
import com.cat.demo.entity.House;
import com.cat.demo.service.HouseService;

@Service
public class HouseServiceImpl implements HouseService {

	@Resource
	private HouseDao houseDao;

	@Override
	public List<House> findList(String name, RentState rentState, Boolean used) {
		return houseDao.findList(-1, name, rentState, used);
	}

	@Override
	public int count(String name, RentState rentState, Boolean used) {
		return houseDao.count(-1, name, rentState, used);
	}

	@Override
	public List<Map<String, Object>> findListWithFee(String name, RentState rentState, Boolean used, Date date, String sort, String order, int pageNo, int pageSize) {
		return houseDao.findListWithFee(-1, name, rentState, used, date, sort, order, pageNo - 1, pageSize);
	}

}
