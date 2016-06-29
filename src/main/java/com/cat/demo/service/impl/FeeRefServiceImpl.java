package com.cat.demo.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.cat.demo.constant.DictEnum.FeeType;
import com.cat.demo.constant.DictEnum.GridType;
import com.cat.demo.dao.FeeRefDao;
import com.cat.demo.entity.FeeRef;
import com.cat.demo.service.FeeRefService;

@Service
public class FeeRefServiceImpl implements FeeRefService {

	@Resource
	private FeeRefDao feeRefDao;

	// TODO 测试,暂时不考虑date...
	@Override
	public FeeRef find(int gridId, GridType gridType, FeeType feeType, Date date) {
		List<FeeRef> feeRefs = feeRefDao.findList(gridId, gridType, feeType, null, null);
		return CollectionUtils.isEmpty(feeRefs) ? null : feeRefs.get(0);
	}

}
