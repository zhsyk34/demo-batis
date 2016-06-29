package com.cat.demo.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.cat.demo.constant.DictEnum;
import com.cat.demo.constant.DictEnum.FeeType;
import com.cat.demo.constant.DictEnum.GridType;
import com.cat.demo.dao.BaseDao;
import com.cat.demo.dao.FeeRefDao;
import com.cat.demo.entity.FeeRef;

/**
 * Created by Archimedes on 2016/6/26.
 */
@Repository
public class FeeRefDaoImpl extends BaseDao<FeeRef, Integer> implements FeeRefDao {
	@Override
	public int save(FeeRef feeRef) {
		return super.save(feeRef);
	}

	@Override
	public int update(FeeRef feeRef) {
		return super.update(feeRef);
	}

	@Override
	public FeeRef find(int id) {
		return super.findById(id);
	}

	@Override
	public List<FeeRef> findList(int gridId, DictEnum.GridType gridType, DictEnum.FeeType feeType, Date begin, Date end, String sort, String order, int offset, int length) {
		Map<String, Object> map = new HashMap<>();

		if (gridId > 0) {
			map.put("gridId", gridId);
		}
		if (gridType != null) {
			map.put("gridType", gridType);
		}
		if (feeType != null) {
			map.put("feeType", feeType);
		}
		if (begin != null) {
			map.put("begin", begin);
		}
		if (end != null) {
			map.put("end", end);
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
	public List<FeeRef> findList(int gridId, GridType gridType, FeeType feeType, Date begin, Date end) {
		return this.findList(gridId, gridType, feeType, begin, end, null, null, -1, -1);
	}
}
