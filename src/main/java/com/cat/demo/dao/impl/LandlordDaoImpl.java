package com.cat.demo.dao.impl;

import com.cat.demo.dao.BaseDao;
import com.cat.demo.dao.LandlordDao;
import com.cat.demo.entity.Landlord;
import com.cat.demo.util.ArrayUtils;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Archimedes on 2016/6/26.
 */
@Repository
public class LandlordDaoImpl extends BaseDao<Landlord, Integer> implements LandlordDao {

	@Override
	public int save(Landlord landlord) {
		int userId = landlord.getUserId();
		if (this.findByUser(userId) == null) {
			return super.save(landlord);
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
	public int delete(Landlord landlord) {
		return super.deleteByEntity(landlord);
	}

	@Override
	public int delete(List<Landlord> landlords) {
		return super.deleteByEntities(landlords);
	}

	@Override
	public Landlord find(int id) {
		return super.findById(id);
	}

	@Override
	public List<Landlord> findList(int userId, String sort, String order, int offset, int length) {
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
	public Landlord findByUser(int userId) {
		List<Landlord> landlords = this.findList(userId, null, null, -1, -1);
		return CollectionUtils.isEmpty(landlords) ? null : landlords.get(0);
	}

	@Override
	public int count() {
		return super.count(null);
	}

}
