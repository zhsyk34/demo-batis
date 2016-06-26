package com.cat.demo.dao;

import com.cat.demo.constant.DictEnum;
import com.cat.demo.entity.FeeRef;

import java.util.Date;
import java.util.List;

/**
 * Created by Archimedes on 2016/6/26.
 */
public interface FeeRefDao {

	int save(FeeRef feeRef);

	int update(FeeRef feeRef);

	FeeRef find(int id);

	List<FeeRef> findList(int gridId, DictEnum.GridType gridType, DictEnum.FeeType feeType, Date begin, Date end, String sort, String order, int offset, int length);
}
