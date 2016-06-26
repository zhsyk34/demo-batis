package com.cat.demo.controller;

import javax.annotation.Resource;

import com.cat.demo.service.HouseService;
import com.cat.demo.service.OrderService;

/**
 * Created by Archimedes on 2016/6/26.
 */
public class BaseController {

	@Resource
	protected HouseService houseService;
	@Resource
	protected OrderService orderService;

	protected int pageNo = 1;
	protected int pageSize = 10;
	protected String sort = "id";
	protected String order = "asc";

}
