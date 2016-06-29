package com.cat.demo.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.cat.demo.constant.DictEnum;
import com.cat.demo.constant.DictEnum.RentState;
import com.cat.demo.dao.BaseDao;
import com.cat.demo.dao.HouseDao;
import com.cat.demo.entity.House;
import com.cat.demo.util.FormatUtil;

/**
 * Created by Archimedes on 2016/6/26.
 */
@Repository
public class HouseDaoImpl extends BaseDao<House, Integer> implements HouseDao {
	@Override
	public int save(House house) {
		return super.save(house);
	}

	@Override
	public int update(House house) {
		return super.update(house);
	}

	@Override
	public House find(int id) {
		return super.findById(id);
	}

	@Override
	public List<House> findList(int landlordId, String name, DictEnum.RentState rentState, Boolean used, String sort, String order, int offset, int length) {
		Map<String, Object> map = new HashMap<>();
		if (landlordId > 0) {
			map.put("landlordId", landlordId);
		}
		if (StringUtils.isNotBlank(name)) {
			map.put("name", "%" + name + "%");
		}
		if (rentState != null) {
			map.put("rentState", rentState);
		}
		if (used != null) {
			map.put("used", used);
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
	public List<House> findList(int landlordId, String name, DictEnum.RentState rentState, Boolean used) {
		return this.findList(landlordId, name, rentState, used, null, null, -1, -1);
	}

	@Override
	public List<House> findList(String name, RentState rentState, Boolean used) {
		return this.findList(-1, name, rentState, used);
	}

	@Override
	public List<House> findList(int landlordId) {
		return this.findList(landlordId, null, null, null);
	}

	@Override
	public int count(int landlordId, String name, DictEnum.RentState rentState, Boolean used) {
		Map<String, Object> map = new HashMap<>();
		if (landlordId > 0) {
			map.put("landlordId", landlordId);
		}
		if (StringUtils.isNotBlank(name)) {
			map.put("name", "%" + name + "%");
		}
		if (rentState != null) {
			map.put("rentState", rentState.toString());
		}
		if (used != null) {
			// map.put("used", FormatUtil.booleanToInt(used));
			map.put("used", used);
		}

		return super.count(map);
	}

	@Override
	public int count(String name, RentState rentState, Boolean used) {
		return this.count(-1, name, rentState, used);
	}

	// TODO:测试用,暂时未从时间date中筛选数据...
	@Override
	public List<Map<String, Object>> findListWithFee(int landlordId, String name, RentState rentState, Boolean used, Date date, String sort, String order, int offset, int length) {
		Map<String, Object> map = new HashMap<>();
		if (landlordId > 0) {
			map.put("landlordId", landlordId);
		}
		if (StringUtils.isNotBlank(name)) {
			map.put("name", "%" + name + "%");
		}
		if (rentState != null) {
			map.put("rentState", rentState.toString());
		}
		if (used != null) {
			map.put("used", FormatUtil.booleanToInt(used));
		}
		if (StringUtils.isNotBlank(sort) && StringUtils.isNotBlank(order)) {
			map.put("sort", sort);
			map.put("order", order);
		}
		if (offset >= 0 && length > 0) {
			map.put("offset", offset);
			map.put("length", length);
		}
		return super.findList("findListWithFee", map);
	}

	@Override
	public List<Map<String, Object>> findListWithFee(int landlordId, String name, RentState rentState, Boolean used, Date date) {
		return this.findListWithFee(landlordId, name, rentState, used, date, null, null, -1, -1);
	}

	@Override
	public List<Map<String, Object>> findListWithFee(String name, RentState rentState, Boolean used, Date date) {
		return this.findListWithFee(name, rentState, used, date);
	}

	@Override
	public List<Map<String, Object>> findListWithFee(String name, RentState rentState, Boolean used) {
		return this.findListWithFee(name, rentState, used, new Date());
	}

}
