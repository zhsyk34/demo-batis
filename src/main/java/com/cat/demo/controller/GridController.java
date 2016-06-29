package com.cat.demo.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cat.demo.constant.DictEnum.RentState;
import com.cat.demo.util.FormatUtil;

/**
 * Created by Archimedes on 2016/6/26.
 */
@Controller
@RequestMapping("/grid")
public class GridController extends BaseController {

	@RequestMapping(value = "/house")
	@ResponseBody
	public Map<String, Object> house(String name, String state, Integer used, int pageNo, int pageSize) {
		RentState rentState = FormatUtil.getEnum(RentState.class, state);
		Boolean usedBoolean = FormatUtil.intToBoolean(used);
		data.put("pageNo", pageNo);
		data.put("pageSize", pageSize);
		List<Map<String, Object>> list = houseService.findListWithFee(name, rentState, usedBoolean, new Date(), name, state, pageNo, pageSize);
		int count = houseService.count(name, rentState, usedBoolean);
		data.put("list", list);
		data.put("count", count);
		return data;
	}

	@RequestMapping(value = "/room")
	@ResponseBody
	public List<Map<String, Object>> room(int houseId) {
		List<Map<String, Object>> rooms = roomService.findListWithFee(houseId);
		return rooms;
	}

}
