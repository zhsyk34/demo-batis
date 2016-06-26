package com.cat.demo.dao;

import com.cat.demo.constant.DictEnum;
import com.cat.demo.entity.FeeCount;

import java.util.Date;
import java.util.List;

/**
 * Created by Archimedes on 2016/6/26.
 */
public interface FeeCountDao {

	int save(FeeCount feeCount);

	FeeCount find(int id);

	List<FeeCount> findList(int houseId, DictEnum.FeeType feeType, Date begin, Date end, String sort, String order, int offset, int length);

}
