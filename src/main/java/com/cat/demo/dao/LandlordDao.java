package com.cat.demo.dao;

import java.util.List;

import com.cat.demo.entity.Landlord;

/**
 * Created by Archimedes on 2016/6/25.
 */
public interface LandlordDao {

	int save(Landlord landlord);

	int delete(int id);

	int delete(int[] ids);

	int delete(Landlord landlord);

	int delete(List<Landlord> landlords);

	Landlord find(int id);

	List<Landlord> findList(int userId, String sort, String order, int offset, int length);

	List<Landlord> findList(String sort, String order, int offset, int length);

	int count();

	Landlord findByUser(int userId);

}
