package com.cat.demo.dao;

import javax.annotation.Resource;

public class BaseTest {

	@Resource
	protected HouseDao houseDao;
	@Resource
	protected RoomDao roomDao;
	@Resource
	protected UserDao userDao;
	@Resource
	protected TenantDao tenantDao;
	@Resource
	protected LandlordDao landlordDao;
	@Resource
	protected FeeRefDao feeRefDao;
}
