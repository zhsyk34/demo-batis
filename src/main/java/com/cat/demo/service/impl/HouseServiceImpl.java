package com.cat.demo.service.impl;

import java.util.List;

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
	public List<House> findList(RentState rentState, Boolean used) {
		return houseDao.findList(-1, null, rentState, used);
	}

}
