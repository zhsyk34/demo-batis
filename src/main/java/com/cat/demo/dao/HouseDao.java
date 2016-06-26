package com.cat.demo.dao;

import com.cat.demo.constant.DictEnum;
import com.cat.demo.entity.House;

import java.util.List;

/**
 * Created by Archimedes on 2016/6/26.
 */
public interface HouseDao {

	int save(House house);

	int update(House house);

	House find(int id);

	List<House> findList(int landlordId, String name, DictEnum.RentState rentState, Boolean used, String sort, String order, int offset, int length);

	List<House> findList(int landlordId, String name, DictEnum.RentState rentState, Boolean used);

	List<House> findListByLandlord(int landlordId);

	int count(int landlordId, String name, DictEnum.RentState rentState, Boolean used);
}
