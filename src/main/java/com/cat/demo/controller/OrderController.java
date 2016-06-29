package com.cat.demo.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cat.demo.constant.DictEnum.GridType;
import com.cat.demo.constant.FeedBack;
import com.cat.demo.util.FormatUtil;

/**
 * Created by Archimedes on 2016/6/26.
 */
@Controller
@RequestMapping("/order")
public class OrderController extends BaseController {

	@RequestMapping(value = "/save")
	@ResponseBody
	public String save(int houseId, int[] roomIds, String type) {
		GridType gridType = FormatUtil.getEnum(GridType.class, type);
		// TODO 从session中获取...
		int tenantId = 1;
		// TODO date...
		boolean result = orderService.save(houseId, tenantId, roomIds, gridType, new Date(), new Date());
		return result ? FeedBack.SUCCESS.toString() : FeedBack.ERROR.toString();
	}
}
