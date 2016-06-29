package com.cat.demo.dao;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cat.demo.constant.DictEnum;
import com.cat.demo.constant.DictEnum.CalcType;
import com.cat.demo.constant.DictEnum.FeeType;
import com.cat.demo.constant.DictEnum.GridType;
import com.cat.demo.entity.FeeRef;
import com.cat.demo.entity.House;
import com.cat.demo.entity.Landlord;
import com.cat.demo.entity.Room;
import com.cat.demo.entity.Tenant;
import com.cat.demo.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml" })
public class InitTest extends BaseTest {

	private long current = System.currentTimeMillis();

	@Test
	public void addUser() {

		for (int i = 1; i <= 6; i++) {
			User user = new User();
			user.setName("name" + i);

			long offset = RandomUtils.nextLong(10 * 365, 30 * 365) * (1000 * 3600 * 24);
			Date date = new Date(current - offset);
			user.setBirthday(date);

			userDao.save(user);

			if (RandomUtils.nextInt(1, 10) > 5) {
				Tenant tenant = new Tenant();
				tenant.setUserId(i);

				tenantDao.save(tenant);
			} else {
				Landlord landlord = new Landlord();
				landlord.setUserId(i);
				landlordDao.save(landlord);
			}

		}
	}

	@Test
	public void addGrid() {

		for (int i = 1; i <= 4; i++) {
			House house = new House();
			house.setName("170" + i);

			long offset = RandomUtils.nextLong(20 * 365, 30 * 365) * (1000 * 3600 * 24);
			Date date = new Date(current - offset);

			house.setBuildTime(date);
			house.setLandlordId(i);
			house.setRentState(DictEnum.RentState.values()[i - 1]);
			house.setUsed(false);
			house.setArea(BigDecimal.ONE);

			int rooms = RandomUtils.nextInt(2, 5);
			house.setRooms(rooms);
			houseDao.save(house);

			BigDecimal houseArea = BigDecimal.ZERO;
			for (int j = 1; j <= rooms; j++) {
				Room room = new Room();
				room.setHouseId(house.getId());// 获取id
				BigDecimal roomArea = new BigDecimal(RandomUtils.nextDouble(20, 50));
				houseArea = houseArea.add(roomArea);
				room.setArea(roomArea);
				room.setName("A-00" + j);

				roomDao.save(room);

				// room fee
				FeeRef roomFee = new FeeRef();
				roomFee.setGridId(room.getId());
				roomFee.setGridType(GridType.ROOM);
				roomFee.setBegin(date);
				roomFee.setFeeType(FeeType.RENT);// 房租

				int k = RandomUtils.nextInt(0, 2);
				roomFee.setCalcType(CalcType.values()[k]);
				roomFee.setUnit(k == 0 ? "元/平方米" : "间");
				roomFee.setPrice(new BigDecimal(k == 0 ? 40 : 800));
				feeRefDao.save(roomFee);
			}
			System.out.println(houseArea);// house area
			house.setArea(houseArea);
			houseDao.update(house);

			// house fee
			FeeRef houseFee = new FeeRef();
			houseFee.setGridId(house.getId());
			houseFee.setGridType(GridType.HOUSE);
			houseFee.setBegin(date);
			houseFee.setFeeType(FeeType.RENT);// 房租

			int k = RandomUtils.nextInt(0, 2);

			houseFee.setCalcType(CalcType.values()[k]);
			houseFee.setUnit(k == 0 ? "元/平方米" : "套");
			houseFee.setPrice(new BigDecimal(k == 0 ? 40 : 3000));
			feeRefDao.save(houseFee);
		}
	}

}
