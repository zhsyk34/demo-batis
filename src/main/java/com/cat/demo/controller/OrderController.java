package com.cat.demo.controller;

import com.cat.demo.entity.Order;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Archimedes on 2016/6/26.
 */
@Controller
@RequestMapping("/order")
public class OrderController extends BaseController {

	@RequestMapping(value = "/index")
	@ResponseBody
	public List<Order> index() {
		return orderService.findList(pageNo, pageSize);
	}
}
