package com.cat.demo.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.cat.demo.constant.DictEnum;
import com.cat.demo.entity.House;

/**
 * Created by Archimedes on 2016/6/26.
 */
public interface HouseDao {

	int save(House house);

	int update(House house);

	House find(int id);

	List<House> findList(int landlordId, String name, DictEnum.RentState rentState, Boolean used, String sort, String order, int offset, int length);

	List<House> findList(int landlordId, String name, DictEnum.RentState rentState, Boolean used);

	List<House> findList(String name, DictEnum.RentState rentState, Boolean used);

	// 某房东房源
	List<House> findList(int landlordId);

	int count(int landlordId, String name, DictEnum.RentState rentState, Boolean used);

	int count(String name, DictEnum.RentState rentState, Boolean used);

	/* 同时查询房租相关信息 */

	List<Map<String, Object>> findListWithFee(int landlordId, String name, DictEnum.RentState rentState, Boolean used, Date date, String sort, String order, int offset, int length);

	// 不排序,不分页
	List<Map<String, Object>> findListWithFee(int landlordId, String name, DictEnum.RentState rentState, Boolean used, Date date);

	// ...根据service需要进行其它友好封装...,也可在service中传递[无效]参数

	// 页面展示需要...
	List<Map<String, Object>> findListWithFee(String name, DictEnum.RentState rentState, Boolean used, Date date);

	// 默认查询日期为当前时间
	List<Map<String, Object>> findListWithFee(String name, DictEnum.RentState rentState, Boolean used);
}
