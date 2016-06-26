package com.cat.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cat.demo.constant.DictEnum.RentState;
import com.cat.demo.entity.House;
import com.cat.demo.util.FormatUtil;

/**
 * Created by Archimedes on 2016/6/26.
 */
@Controller
@RequestMapping("/grid")
public class GridController extends BaseController {

	@RequestMapping(value = "/list")
	@ResponseBody
	public List<House> list(String state, Integer used) {
		System.out.println(state);
		System.out.println(used);
		RentState rentState = FormatUtil.getEnum(RentState.class, state);
		Boolean usedBoolean = FormatUtil.intToBoolean(used);
		List<House> houses = houseService.findList(rentState, usedBoolean);
		return houses;
	}
}
