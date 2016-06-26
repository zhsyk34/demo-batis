package com.cat.demo.dao;

import com.cat.demo.entity.Tenant;

import java.util.List;

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

	Tenant findByUser(int userId);

	int count();

}
