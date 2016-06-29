package com.cat.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.cat.demo.service.FeeRefService;
import com.cat.demo.service.HouseService;
import com.cat.demo.service.OrderService;
import com.cat.demo.service.RoomService;

/**
 * Created by Archimedes on 2016/6/26.
 */
public class BaseController {

	@Resource
	protected HouseService houseService;
	@Resource
	protected RoomService roomService;
	@Resource
	protected OrderService orderService;
	@Resource
	protected FeeRefService feeRefService;

	protected int pageNo = 1;
	protected int pageSize = 10;
	protected String sort = "id";
	protected String order = "asc";

	protected Map<String, Object> data = new HashMap<>();

}
