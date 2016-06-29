package com.cat.demo.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cat.demo.constant.DictEnum;
import com.cat.demo.entity.House;

/**
 * Created by Archimedes on 2016/6/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml" })
public class HouseDaoTest {
	@Resource
	private HouseDao houseDao;

	@Test
	public void save() throws Exception {

		for (int i = 1; i < 6; i++) {
			House house = new House();
			house.setName("170" + i);
			house.setArea(new BigDecimal(RandomUtils.nextDouble(30, 300)));
			house.setBuildTime(new Date());
			house.setLandlordId(i % 2 + i);
			house.setRentState(DictEnum.RentState.WHOLE);
			house.setRooms(RandomUtils.nextInt(1, 9));
			house.setUsed(RandomUtils.nextDouble(1, 3) > 2);

			houseDao.save(house);
		}
	}

	@Test
	public void find() throws Exception {
		House house = houseDao.find(2);
		System.out.println(house);
	}

	@Test
	public void findList() throws Exception {
		List<House> houses = houseDao.findList(4);
		houses.forEach(house -> System.out.println(house));
	}

	@Test
	public void findList1() throws Exception {
		// List<House> houses = houseDao.findList(-1, DictEnum.RentState.BOTH,
		// false);
		// houses.forEach(house -> System.out.println(house));
	}

	@Test
	public void findList2() throws Exception {
		List<Map<String, Object>> list = houseDao.findListWithFee(-1, null, null, null, null);
		list.forEach(map -> System.out.println(map));
	}

	@Test
	public void count() throws Exception {
		int count = houseDao.count(-1, null, null, true);
		System.out.println(count);
	}

}
