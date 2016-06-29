package com.cat.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cat.demo.constant.DictEnum.FeeType;
import com.cat.demo.constant.DictEnum.GridType;
import com.cat.demo.entity.FeeRef;
import com.cat.demo.entity.Room;

/**
 * Created by Archimedes on 2016/6/26.
 */
@Controller
@RequestMapping("/fee")
public class FeeController extends BaseController {

	@RequestMapping(value = "/find")
	@ResponseBody
	public List<FeeRef> find(int gridId, String gridType, String feeType) {
		// room: feeRefService.find(gridId, GridType.ROOM, FeeType.RENT, null);
		// 这里测试house...

		List<Room> rooms = roomService.findList(gridId);
		List<FeeRef> feeRefs = new ArrayList<>();
		for (Room room : rooms) {
			FeeRef feeRef = feeRefService.find(room.getId(), GridType.ROOM, FeeType.RENT, null);
			feeRefs.add(feeRef);
		}
		return feeRefs;

	}

}
