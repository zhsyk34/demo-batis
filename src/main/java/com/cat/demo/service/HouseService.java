package com.cat.demo.service;

import java.util.List;

import com.cat.demo.constant.DictEnum.RentState;
import com.cat.demo.entity.House;

public interface HouseService {

	List<House> findList(RentState rentState, Boolean used);
}
