package com.cat.demo.dao;

import java.util.List;

import com.cat.demo.entity.Tenant;

/**
 * Created by Archimedes on 2016/6/25.
 */
public interface TenantDao {

	int save(Tenant tenant);

	int delete(int id);

	int delete(int[] ids);

	int delete(Tenant tenant);

	int delete(List<Tenant> tenants);

	int update(Tenant tenant);

	Tenant find(int id);

	List<Tenant> findList(int userId, String sort, String order, int offset, int length);

	List<Tenant> findList(String sort, String order, int offset, int length);

	int count();

	Tenant findByUser(int userId);

}
