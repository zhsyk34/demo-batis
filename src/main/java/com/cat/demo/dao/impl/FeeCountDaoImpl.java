package com.cat.demo.dao.impl;

import com.cat.demo.constant.DictEnum;
import com.cat.demo.dao.BaseDao;
import com.cat.demo.dao.FeeCountDao;
import com.cat.demo.entity.FeeCount;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Archimedes on 2016/6/26.
 */
@Repository
public class FeeCountDaoImpl extends BaseDao<FeeCount, Integer> implements FeeCountDao {

	@Override
	public int save(FeeCount feeCount) {
		return super.save(feeCount);
	}

	@Override
	public FeeCount find(int id) {
		return super.findById(id);
	}

	@Override
	public List<FeeCount> findList(int houseId, DictEnum.FeeType feeType, Date begin, Date end, String sort, String order, int offset, int length) {
		Map<String, Object> map = new HashMap<>();

		if (houseId > 0) {
			map.put("houseId", houseId);
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

}
