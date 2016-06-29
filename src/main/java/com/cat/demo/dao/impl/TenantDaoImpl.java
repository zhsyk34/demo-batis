package com.cat.demo.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.cat.demo.dao.BaseDao;
import com.cat.demo.dao.TenantDao;
import com.cat.demo.entity.Tenant;
import com.cat.demo.util.ArrayUtils;

/**
 * Created by Archimedes on 2016/6/26.
 */
@Repository
public class TenantDaoImpl extends BaseDao<Tenant, Integer> implements TenantDao {

	@Override
	public int save(Tenant tenant) {
		int userId = tenant.getUserId();

		if (this.findByUser(userId) == null) {
			return super.save(tenant);
		}
		return -1;
	}

	@Override
	public int delete(int id) {
		return super.deleteById(id);
	}

	@Override
	public int delete(int[] ids) {
		return super.deleteByIds(ArrayUtils.toWrap(ids));
	}

	@Override
	public int delete(Tenant tenant) {
		return super.deleteByEntity(tenant);
	}

	@Override
	public int delete(List<Tenant> tenants) {
		return super.deleteByEntities(tenants);
	}

	@Override
	public Tenant find(int id) {
		return super.findById(id);
	}

	@Override
	public List<Tenant> findList(int userId, String sort, String order, int offset, int length) {
		Map<String, Object> map = new HashMap<>();
		if (userId > 0) {
			map.put("userId", userId);
		}
		if (StringUtils.isNotBlank(sort) && StringUtils.isNotBlank(order)) {
			map.put("sort", sort);
			map.put("order", order);
		}
		if (offset >= 0 && length > 0) {
			map.put("offset", offset);
			map.put("length", length);
		}
		return super.findList(map);
	}

	@Override
	public List<Tenant> findList(String sort, String order, int offset, int length) {
		return this.findList(-1, sort, order, offset, length);
	}

	@Override
	public int count() {
		return super.count(null);
	}

	@Override
	public Tenant findByUser(int userId) {
		List<Tenant> tenants = this.findList(userId, null, null, -1, -1);
		return CollectionUtils.isEmpty(tenants) ? null : tenants.get(0);
	}

}
